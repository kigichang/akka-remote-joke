package com.example

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

object DeployClient extends App {
  val system = ActorSystem("DeployClient", ConfigFactory.load("deploy-client"))
    
  val reporter = system.actorOf(Props(classOf[Reporter], null), "penguin")
  
  /* 主程式等一下，要不然上面都是 non-blocking call，會直接結束程式 */
  Thread.sleep(10000)
  system.shutdown
  println("end")
}