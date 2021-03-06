package me.principality.tcp

import akka.actor.{Actor, ActorRef}
import akka.util.ByteString
import com.typesafe.config.{Config, ConfigFactory}

class ProtocolHandler extends Actor {

  import akka.io.Tcp._

  val handler: BaseHandler = createHandler()
  var buffer: Option[ByteString] = None

  override def receive: Receive = {
    case Received(data) =>
      val remainder = handler.handle(buffer match {
        case Some(s) => s ++ data
        case None => data
      }, sender())
      buffer = remainder
    case connection: ActorRef =>
      handler.onConnect(connection)
    case PeerClosed => context stop self
  }

  private def createHandler(): BaseHandler = {
    val conf: Config = ConfigFactory.load()
    val backend: String = conf.getString("backend.type")

    backend match {
      case "MySQL" => new MySQLHandler()
      case "Postgres" => new PostgresHandler()
      case "Echo" => new EchoHandler()
    }
  }
}
