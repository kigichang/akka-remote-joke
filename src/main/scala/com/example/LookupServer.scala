package com.example

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.ActorRef
import akka.actor.Props

object LookupServer extends App {
  
  val system = ActorSystem("LookupServer", ConfigFactory.load("lookup-server"))
 
  val penguins = new Array[ActorRef](10)

  for (i <- 0 to 8) {
    penguins(i) = system.actorOf(Props(classOf[Penguin], s"Penguin-$i"), s"penguin-$i")
  }

  penguins(9) = system.actorOf(Props[DongDong], "dongdong")
  
}