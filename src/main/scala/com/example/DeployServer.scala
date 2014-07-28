package com.example

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

object DeployServer extends App {
  val system = ActorSystem("DeployServer", ConfigFactory.load("deploy-server"))
}