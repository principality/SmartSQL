package me.principality.protocol.mysql.util

import java.nio.charset.Charset

import scodec.{Attempt, Codec, DecodeResult, Err, Platform, SizeBound}
import scodec.bits.BitVector
import scodec.codecs.{utf8, filtered}

object MySQLCodec {
  val ustring: Codec[String] = filtered(utf8, new Codec[BitVector] {
    val nul = BitVector.lowByte
    override def sizeBound: SizeBound = SizeBound.unknown
    override def encode(bits: BitVector): Attempt[BitVector] = Attempt.successful(bits ++ nul)
    override def decode(bits: BitVector): Attempt[DecodeResult[BitVector]] = {
      bits.bytes.indexOfSlice(nul.bytes) match {
        case -1 => Attempt.failure(Err("Does not contain a 'NUL' termination byte."))
        case i => Attempt.successful(DecodeResult(bits.take(i * 8L), bits.drop(i * 8L + 8L)))
      }
    }
  }).withToString("ustring")
}
