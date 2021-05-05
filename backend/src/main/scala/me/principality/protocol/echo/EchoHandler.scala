
package me.principality.protocol.echo

import me.principality.protocol.BaseHandler

class EchoHandler extends BaseHandler {
  override def handle(packet: ByteString, sender: ActorRef): Option[ByteString] = {
    sender ! Write(packet)
    None
  }

  override def onConnect(connection: ActorRef): Unit = ???
}
