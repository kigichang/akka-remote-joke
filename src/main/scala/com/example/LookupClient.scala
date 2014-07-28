package com.example

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import akka.actor.ActorRef

object LookupClient extends App {
  val system = ActorSystem("LookupClient", ConfigFactory.load("lookup-client"))
  
  val remotePath = "akka.tcp://LookupServer@127.0.0.1:2552/user/"
    
  val penguins = new Array[String](10)

  for (i <- 0 to 8) {
    penguins(i) = remotePath + (s"penguin-$i")
  }

  penguins(9) = remotePath + "dongdong"

  val reporter = system.actorOf(Props(classOf[Reporter], penguins), "reporter")
  
  /* 主程式等一下，要不然上面都是 non-blocking call，會直接結束程式 */
  Thread.sleep(10000)
  system.shutdown
  println("end")
}