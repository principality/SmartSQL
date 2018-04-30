package me.principality.smartsql.tcp

import akka.actor.Actor
import akka.util.ByteString
import com.typesafe.scalalogging.Logger
import me.principality.smartsql.protocol.BaseHandler
import me.principality.smartsql.protocol.mysql.MySQLHandler

class ProtocolHandler extends Actor {

  import akka.io.Tcp._

  val handler: BaseHandler = new MySQLHandler()
  val logger: Logger = Logger[ProtocolHandler]
  var buffer: ByteString = _

  override def receive: Receive = {
    case Received(data) =>
      logger.debug(data.toString())
      val (packet, remainder) = handler.handle(buffer ++ data, sender())
      if (remainder.nonEmpty)
      //context become self(remaider) // 回调receive
        buffer = remainder
      else
        buffer = ByteString("")
    case PeerClosed => context stop self
  }
}
