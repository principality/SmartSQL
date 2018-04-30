package me.principality.smartsql.protocol.mysql

import java.nio.ByteOrder

import akka.actor.ActorRef
import akka.util.ByteString
import me.principality.smartsql.protocol.BaseHandler

import scala.annotation.tailrec

/**
  * MySQL协议处理
  *
  * MySQL客户端GPL授权的原因，建议使用 MariaDB Connector/J
  * https://downloads.mariadb.org/connector-java/+releases/
  * https://mariadb.com/kb/en/library/about-mariadb-connector-j/
  *
  * 或者采取开源的方式，使用MySQL Connector/J，也不会有问题，
  * 关于GPL的进一步解释，可上网搜索获得
  * https://stackoverflow.com/questions/620696/mysql-licensing-and-gpl
  *
  * 下面是关于MySQL的协议说明：
  * https://dev.mysql.com/doc/internals/en/client-server-protocol.html
  * http://hutaow.com/blog/2013/11/06/mysql-protocol-analysis/
  *
  * 1. 建立tcp三次握手连接
  * 2. 客户端与服务器建立连接，Connection Phase
  *    s->c 发送握手初始包
  *    c->s 发送验证包
  *    s->c 服务器发送认证结果包
  * 3. 认证通过后，服务器接受客户端命令包并发送响应包，Command Phase
  * 4. 客户端断开连接请求 exit 命令
  * 5. 四次挥手断开连接
  *
  * SQL命令包的解析分为：
  * 1. 完成TCP分包拆包
  * 2. 对完整的包进行解析，提取SQL
  * 3. 调用SQL解析处理器
  */
private[smartsql] class MySQLHandler extends BaseHandler {
  override def handle(packet: ByteString, sender: ActorRef): Unit = {
    // TODO 记得要把packet frame的逻辑加上
    // TODO 对包处理的缓冲机制要仔细考虑，必须注意太多客户端连接导致OOM的问题
    parsePacket(packet)
  }

  /**
    * Extracts complete packets of the specified length, preserving remainder
    * data. If there is no complete packet, then we return an empty list. If
    * there are multiple packets available, all packets are extracted, Any remaining data
    * is returned to the caller for later submission
    *
    * @param packet A list of the packets extracted from the raw data in order of receipt
    * @return A list of ByteStrings containing extracted packets as well as any remaining buffer data not consumed
    */
  def parsePacket(packet: ByteString): (List[ByteString], ByteString) = {
    implicit val byteOrder: ByteOrder = java.nio.ByteOrder.LITTLE_ENDIAN // 小端排序

    val MAX_PACKET_LEN: Int = 16 << 8 // 16M
    val headerSize = 2

    @tailrec
    def multiPacket(packets: List[ByteString], current: ByteString): (List[ByteString], ByteString) = {
      if (current.length < headerSize) {
        (packets.reverse, current)
      } else {
        val len = current.iterator.getShort
        if (len > MAX_PACKET_LEN || len < 0) throw new RuntimeException(s"Invalid packet length: $len")
        if (current.length < len + headerSize) {
          (packets.reverse, current)
        } else {
          val rem = current drop headerSize // Pop off header
          val (front, back) = rem.splitAt(len) // Front contains a completed packet, back contains the remaining data
          // Pull of the packet and recurse to see if there is another packet available
          multiPacket(front :: packets, back)
        }
      }
    }

    multiPacket(List[ByteString](), packet)
  }

  def parseMySQL(command: ByteString): ByteString = {
    ???
  }

  def parseSQL(packet: ByteString): Unit = {
    ???
  }


}
