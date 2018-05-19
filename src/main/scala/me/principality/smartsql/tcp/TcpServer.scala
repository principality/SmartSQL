package me.principality.smartsql.tcp

import java.net.InetSocketAddress
import akka.actor.{Actor, Props}
import akka.io.Tcp._
import akka.io.{IO, Tcp}

/**
  * Tcp Server implementation
  */
class TcpServer(address: String, port: Int) extends Actor {

  import context.system

  val manager = IO(Tcp)
  manager ! Bind(self, new InetSocketAddress(address, port))

  override def receive: Receive = {
    case b@Bound(localAddress) => context.parent ! b
    case CommandFailed(_: Bind) => context stop self
    case c@Connected(remote, local) => {
      val handler = context.actorOf(Props[ProtocolHandler])
      val connection = sender()
      handler ! connection
      connection ! Register(handler)
    }
  }
}

/**
  * Create a instance of TcpServer
  */
object TcpServer {
  def props(address: String, port: Int) = Props(new TcpServer(address, port))
}