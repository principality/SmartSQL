package me.principality.smartsql.protocol.postgres

import akka.actor.ActorRef
import akka.util.ByteString
import me.principality.smartsql.protocol.BaseHandler

class PostgresHandler extends BaseHandler {
  override def handle(packet: ByteString, sender: ActorRef): Option[ByteString] = {
    None
  }
}
