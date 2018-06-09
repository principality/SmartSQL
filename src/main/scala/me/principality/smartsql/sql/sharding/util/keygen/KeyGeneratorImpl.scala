package me.principality.smartsql.sql.sharding.util.keygen

import java.util.Calendar
import scala.collection.mutable

/**
  * Default distributed primary key generator.
  *
  * Use snowflake algorithm. Length is 64 bit.
  *
  * 1bit   sign bit.
  * 41bits timestamp offset from 2018.06.01 to now.
  * 10bits worker process id.
  * 12bits auto increment offset in one mills
  *
  */
class KeyGeneratorImpl extends KeyGenerator { self =>
  var EPOCH = 0L
  private val SEQUENCE_BITS = 12L
  private val WORKER_ID_BITS = 10L
  private val SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1
  private val WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS
  private val TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS
  private val WORKER_ID_MAX_VALUE = 1L << WORKER_ID_BITS
  private def getCurrentMillis: Long = System.currentTimeMillis
  private var workerId = 0L
  private var sequence = 0L
  private var lastTime = 0L

  private val calendar = Calendar.getInstance
  calendar.set(2018, Calendar.JUNE, 1)
  calendar.set(Calendar.HOUR_OF_DAY, 0)
  calendar.set(Calendar.MINUTE, 0)
  calendar.set(Calendar.SECOND, 0)
  calendar.set(Calendar.MILLISECOND, 0)
  EPOCH = calendar.getTimeInMillis


  def setWorkerId(workerId: Long): Unit = {
    self.workerId = workerId
  }

  def generateKey: Number = {
    var currentMillis = self.getCurrentMillis
    if (lastTime == currentMillis) {
      var sequeceBits: mutable.BitSet = mutable.BitSet(sequence.toInt)
      if (0L == (sequeceBits = (sequeceBits + 1) & mutable.BitSet(self.SEQUENCE_MASK))) // 如果后12位全部为0
        currentMillis = waitUntilNextTime(currentMillis)
    }
    else sequence = 0
    lastTime = currentMillis
    ((currentMillis - self.EPOCH) << self.TIMESTAMP_LEFT_SHIFT_BITS) | (self.workerId << self.WORKER_ID_LEFT_SHIFT_BITS) | sequence
  }

  private def waitUntilNextTime(lastTime: Long) = {
    var time = self.getCurrentMillis
    while ({
      time <= lastTime
    }) time = self.getCurrentMillis
    time
  }

}
