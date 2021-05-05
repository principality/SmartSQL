package me.principality.jdbc.sharding.define

import java.sql.Statement

trait Connection {
  def getStatement: Statement
}
