package me.principality.smartsql.protocol.mysql

import java.nio.ByteOrder
import akka.util.ByteString
import scala.annotation.tailrec

class Buffering {

  val MAX_PACKET_LEN: Int = 16 << 8 // 16M

  /**
    * Extracts complete packets of the specified length, preserving remainder
    * data. If there is no complete packet, then we return an empty list. If
    * there are multiple packets available, all packets are extracted, Any remaining data
    * is returned to the caller for later submission
    *
    * @param data A list of the packets extracted from the raw data in order of receipt
    * @return A list of ByteStrings containing extracted packets as well as any remaining buffer data not consumed
    */
  def getPacket(data: ByteString): (List[ByteString], ByteString) = {

    implicit val byteOrder: ByteOrder = java.nio.ByteOrder.LITTLE_ENDIAN // 小端排序
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

    multiPacket(List[ByteString](), data)
  }
}
