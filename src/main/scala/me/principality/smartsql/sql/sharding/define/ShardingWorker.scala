package me.principality.smartsql.sql.sharding.define

trait ShardingWorker {
  def execute(sql: String): ResultSet
}