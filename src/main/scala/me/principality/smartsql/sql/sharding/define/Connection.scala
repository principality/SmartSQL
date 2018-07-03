package me.principality.smartsql.sql.sharding.define

import java.sql.Statement

trait Connection {
  def getStatement: Statement
}
