package me.principality.smartsql.protocol

import org.specs2.Specification
import org.specs2.specification.core.SpecStructure

class JdbcSpec extends Specification {
  override def is: SpecStructure =
    s2"""
      sharding jdbc $go
    """

  def go = {
    success
  }
}
