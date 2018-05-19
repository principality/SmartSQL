package me.principality.smartsql.protocol.mysql

object MySQLProtocol {
  val MAX_PACKET_LEN: Int = 16 << 8 // 16M
  val HEADER_SIZE: Int = 2
}

case class ParseContext(seq: Int = 0, isCmdPhase: Boolean = false)