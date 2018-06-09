package me.principality.smartsql.sql.sharding.define

trait Connection {
  def getStatement: Statement
}
