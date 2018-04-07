package me.principality.smartsql.protocol

import akka.actor.ActorRef
import akka.util.ByteString

private[smartsql] trait BaseHandler {
  def handle(packet: ByteString, sender: ActorRef)
}
