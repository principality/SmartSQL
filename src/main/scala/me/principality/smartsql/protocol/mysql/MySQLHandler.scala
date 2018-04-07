package me.principality.smartsql.protocol.mysql

import akka.actor.ActorRef
import akka.util.ByteString
import me.principality.smartsql.protocol.BaseHandler

/**
  * MySQL协议处理
  *
  */
private[smartsql] class MySQLHandler extends BaseHandler{
  override def handle(packet: ByteString, sender: ActorRef): Unit = ???
}
