package me.principality.protocol.postgres

import me.principality.protocol.BaseHandler

class PostgresHandler extends BaseHandler {
  override def handle(packet: ByteString, sender: ActorRef): Option[ByteString] = ???

  override def onConnect(connection: ActorRef): Unit = ???
}
