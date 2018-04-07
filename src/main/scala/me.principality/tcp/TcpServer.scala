
package me.principality.tcp


import akka.actor.{Actor, Props}


/**
  * Tcp Server implementation
  */
class TcpServer extends Actor {
  override def receive: Receive = ???
}


/**
  * Create a instance of TcpServer
  */
object TcpServer {
  def props() = Props(new TcpServer)
}