package me.principality.smartsql

import org.specs2._
import org.specs2.specification.core.SpecStructure

class MainSpec extends Specification {

  override def is: SpecStructure =
    s2"""
      check application $start
    """

  def start = {
    success
  }
}
