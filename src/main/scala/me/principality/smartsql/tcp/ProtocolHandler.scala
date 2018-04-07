package me.principality.smartsql.tcp

import akka.actor.Actor
import com.typesafe.scalalogging.Logger
import me.principality.smartsql.protocol.BaseHandler
import me.principality.smartsql.protocol.mysql.MySQLHandler

class ProtocolHandler extends Actor {

  import akka.io.Tcp._

  val handler: BaseHandler = new MySQLHandler()
  val logger: Logger = Logger[ProtocolHandler]

  override def receive: Receive = {
    case Received(data) =>
      logger.debug(data.toString())
      handler.handle(data, sender())
    case PeerClosed => context stop self
  }
}
