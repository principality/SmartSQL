package me.principality.smartsql.tcp

import akka.actor.Actor
import akka.util.ByteString
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import me.principality.smartsql.protocol.BaseHandler
import me.principality.smartsql.protocol.echo.EchoHandler
import me.principality.smartsql.protocol.mysql.MySQLHandler
import me.principality.smartsql.protocol.postgres.PostgresHandler

class ProtocolHandler extends Actor {

  import akka.io.Tcp._

  val handler: BaseHandler = createHandler()
  val logger: Logger = Logger[ProtocolHandler]
  var buffer: Option[ByteString] = None

  override def receive: Receive = {
    // TODO 记得要把packet frame的逻辑加上 https://doc.akka.io/docs/akka/2.2.0/scala/io-codec.html
    case Received(data) =>
      logger.debug(data.toString())
      val remainder = handler.handle(buffer match {
        case Some(s) => s ++ data
        case None => data
      }, sender())
      buffer = remainder
    case PeerClosed => context stop self

    // TODO 主动发送消息到对端
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
