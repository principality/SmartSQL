package me.principality.smartsql.sqlexec.sharding.define

import java.sql.Statement

trait Connection {
  def getStatement: Statement
}
