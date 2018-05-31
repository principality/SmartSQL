package me.principality.smartsql.protocol.mysql

import akka.actor.ActorRef
import me.principality.smartsql.protocol.mysql.MySQLProtocolPhase.ProtocolPhase

object MySQLProtocol {
  val MAX_PACKET_LEN: Int = 16 << 8 // 16M
  val HEADER_SIZE: Int = 2
}

object MySQLProtocolPhase extends Enumeration {
  type ProtocolPhase = Value
  val Connection, Command = Value
}

case class ParseContext
(
  maxSize: Int = MySQLProtocol.MAX_PACKET_LEN,
  seq: Int = 0,
  phase: ProtocolPhase,
  remote: ActorRef
)

trait MySQLRequest {} // 请求命令

trait MySQLResponse {
  def apply(context: ParseContext)
} // 响应命令


case class InitialHandshakeRequest // 服务器发给客户端
(
  protocolVersion: Byte,
  serverVersion: String,
  connectionId: Int,
  authPluginDataPart1: String,
  filter: Byte,
  capabilityFlag1: Seq[Byte],
  characterSet: Byte,
  statusFlag: Seq[Byte],
  capabilityFlag2: Seq[Byte],
  authPluginDataLen: Byte,
  authPluginName: String
) extends MySQLRequest

case class HandshakeResponse
(
  capabilityFlags: Seq[Byte], // 4
  maxPacketSize: Seq[Byte], // 4
  characterSet: Byte, // 1
  username: String, // string fix-length
  authResponse: String, // string Null
  database: String, // string Null
  authPluginName: String // string Null
) extends MySQLRequest