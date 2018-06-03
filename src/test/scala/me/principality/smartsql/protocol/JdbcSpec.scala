package me.principality.smartsql.protocol

import org.specs2.Specification
import org.specs2.specification.core.SpecStructure

/**
  * 对jdbc进行测试，确认后端连接没有问题
  */
class JdbcSpec extends Specification {
  override def is: SpecStructure =
    s2"""
      sharding jdbc $go
    """

  def go = {
    success
  }
}
