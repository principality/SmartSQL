package me.principality.smartsql.calcite

import me.principality.smartsql.sqlexec.JdbcHandler
import org.specs2.Specification
import org.specs2.specification.core.SpecStructure

/**
  * 对jdbc进行测试，确认后端连接没有问题
  */
class JdbcAdapterSpec extends Specification {
  override def is: SpecStructure =
    s2"""
      sharding jdbc $go
    """

  def go = {
    val jdbc = new JdbcHandler
    jdbc.execute("select * from \"user\"")
    success
  }
}
