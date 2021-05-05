package me.principality.protocol

import akka.actor.ActorRef
import akka.util.ByteString

private[smartsql] trait BaseHandler {
  def handle(packet: ByteString, sender: ActorRef): Option[ByteString]
  def onConnect(connection: ActorRef)
}
