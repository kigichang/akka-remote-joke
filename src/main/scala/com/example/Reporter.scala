package com.example

import com.example.message._
import akka.actor.Actor
import akka.actor.Identify
import scala.concurrent.duration._
import akka.actor.ActorIdentity
import akka.actor.Props

/**
 * 記者
 */
class Reporter(var penguins: Array[String]) extends Actor {
  sendIdentifyRequest()
  
  def sendIdentifyRequest() {
    if (penguins != null) {
      penguins.foreach(path => context.actorSelection(path) ! Identify(path))
    }
    else {
      penguins = new Array[String](10)
      for (i <- 0 to 8) {
        val actor = context.actorOf(Props(classOf[Penguin], s"Penguin-$i"))
        actor ! Identify(actor.path.toString())
        penguins(i) = actor.path.toString()
        println(actor.path)
      }
      
      val dong = context.actorOf(Props[DongDong])
      dong ! Identify(dong.path.toString())
      penguins(9) = dong.path.toString()
      println(dong.path)
  
    }
    import context.dispatcher
    context.setReceiveTimeout(5 seconds) // 設定 timeout 5 seconds
  }
  
  
  var count = 0
  def receive = {
    case ActorIdentity(path, Some(actor)) =>
      count += 1
      if (count == penguins.length) {
        context.setReceiveTimeout(Duration.Undefined)
      }
      
      println(s"$path found")
      actor ! Interest()
      
    /* 有三個興趣的回覆 */
    case Three(name, a, b, c) => 
      println(s"$name: $a, $b, $c")
    
    /* 只有二個興趣的回覆，反問 why */      
    case Two(name, a, b) =>
      println(s"$name: $a, $b")
      sender() ! Why()
    
    /* 接到 why 的回覆 */
    case Because(name, msg) =>
      println(s"$name: $msg")
  }
  
  override def preStart() = {
    println("Reporter start")
  }
}