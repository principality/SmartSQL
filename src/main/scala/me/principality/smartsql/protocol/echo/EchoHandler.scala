
package me.principality.smartsql.protocol.echo

import akka.actor.ActorRef
import akka.io.Tcp.Write
import akka.util.ByteString
import me.principality.smartsql.protocol.BaseHandler

class EchoHandler extends BaseHandler {
  override def handle(packet: ByteString, sender: ActorRef): Unit = {
    sender ! Write(packet)
  }
}