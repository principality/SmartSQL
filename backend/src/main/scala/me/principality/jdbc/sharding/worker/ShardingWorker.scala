package me.principality.jdbc.sharding.worker

trait ShardingWorker {
  // 是否为分片表
  def isShard(table: String): Boolean

  // 获取服务器的列表
  def getShardList(table: String): Seq[ShardIndexId]

  // 执行
  def execute(sql: String): ResultSet
}