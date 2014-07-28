package com.example

import com.example.message._
import akka.actor.Actor
/**
 * 企鵝
 */
class Penguin(val name: String) extends Actor {
  def receive = {
    case Interest() =>
      println(name + " got Interest message")
      sender() ! Three(name, "吃飯", "睡覺", "打東東")
  }
  
  override def preStart() = {
    println(s"$name start")
  }
}

/**
 * 叫東東的企鵝
 */
class DongDong extends Penguin("東東") {
  override def receive = {
    case Interest() =>
      println(name + " got Interest message")
      sender() ! Two(name, "吃飯", "睡覺")
    case Why() =>
      println(name + " got Why message")
      sender() ! Because(name, "我就是" + name)
  }
}