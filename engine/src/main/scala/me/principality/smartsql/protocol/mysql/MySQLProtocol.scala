package me.principality.smartsql.protocol.mysql

import java.nio.charset.Charset

import akka.actor.ActorRef
import scodec.Codec
import scodec.bits.{BitVector, ByteVector}
import scodec.codecs._
import me.principality.smartsql.protocol.mysql.MySQLProtocol.MySQLProtocolPhase.ProtocolPhase

object MySQLProtocol {
  val MAX_PACKET_LEN: Int = 16 << 8 // 16M
  val HEADER_SIZE: Int = 2

  implicit val charset = Charset.defaultCharset

  case class ParseContext
  (
    maxSize: Int = MySQLProtocol.MAX_PACKET_LEN,
    seq: Int = 0,
    phase: ProtocolPhase,
    remote: ActorRef
  )

  case class HandshakeV10 // 服务器发给客户端
  (
    header: ByteVector, // 4
    protocolVersion: Byte, // 1
    serverVersion: String, // string Null
    connectionId: Int, // 4
    authPluginDataPart1: ByteVector, // string fix-len 8
    filter: Byte, // 1
    capabilityFlag1: ByteVector, // 2
    characterSet: Byte, // 1
    statusFlag: ByteVector, // 2
    capabilityFlag2: ByteVector, // 2
    authPluginDataLen: Byte, // 1
    reserved: ByteVector, // string fix-len 10
    authPluginDataPart2: String, // string $len = MAX(13, length of auth-plugin-data - 8)
    authPluginName: String // string Null
  )

  case class HandshakeResponse41
  (
    capabilityFlags: Seq[Byte], // 4
    maxPacketSize: Seq[Byte], // 4
    characterSet: Byte, // 1
    username: String, // string fix-length
    authResponse: String, // string Null
    database: String, // string Null
    authPluginName: String // string Null
  )

  // 碰到的问题：1、官方的文档和实际的协议格式对不上；2、部分字段文档没有提及，不知道该如何填写
  implicit val initialHandshakeRequest: Codec[HandshakeV10] = {
    ("header" | bytes(4)) ::
      ("protocolVersion" | byte) ::
      ("serverVersion" | cstring) ::
      ("connectionId" | int32L) ::
      ("authPluginDataPart1" | bytes(8)) ::
      ("filter" | byte) ::
      ("capabilityFlag1" | bytes(2)) ::
      ("characterSet" | byte) ::
      ("statusFlag" | bytes(2)) ::
      ("capabilityFlag2" | bytes(2)) ::
      ("authPluginDataLen" | byte) ::
      ("reserved" | bytes(10)) ::
      ("authPluginDataPart2" | cstring) ::
      ("authPluginName" | cstring)
  }.as[HandshakeV10]

  object MySQLProtocolPhase extends Enumeration {
    type ProtocolPhase = Value
    val Connection, Command = Value
  }

}

