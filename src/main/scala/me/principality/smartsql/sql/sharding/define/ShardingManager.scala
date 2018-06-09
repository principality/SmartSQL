package me.principality.smartsql.sql.sharding.define

trait ShardingManager {
  def execute(sql: String): ResultSet
}