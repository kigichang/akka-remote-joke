package com.example

package message {
  trait Question
  
  case class Interest() extends Question
  case class Why() extends Question
  
  trait Answer
  
  case class Three(name: String, a: String, b: String, c: String) extends Answer
  case class Two(name: String, a: String, b: String) extends Answer
  case class Because(name: String, reason: String) extends Answer
}