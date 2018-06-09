package me.principality.smartsql.sql.sharding.define

trait Statement {
  def execute(sql: String): ResultSet
}
