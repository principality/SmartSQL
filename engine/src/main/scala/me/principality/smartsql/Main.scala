package me.principality.smartsql

import akka.actor.ActorSystem
import com.typesafe.scalalogging.Logger
import me.principality.smartsql.tcp.TcpServer

object Main {
  def main(args: Array[String]): Unit = {
    val logger = Logger("Main")
    logger.info("system init...")

    val system = ActorSystem.create("SmartSQL")
    system.actorOf(TcpServer.props("0.0.0.0", 33060))
  }
}