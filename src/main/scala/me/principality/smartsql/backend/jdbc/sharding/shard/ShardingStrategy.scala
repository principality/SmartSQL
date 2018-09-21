package me.principality.smartsql.sqlexec.sharding.shard

import me.principality.smartsql.sqlexec.sharding.define.Database

/**
  * 通过sharding key从当前的可用数据库连接中，获得需要发送SQL的目标数据库连接集合
  */
trait ShardingStrategy {

  def init(rule: ShardingRule)

  def doShard(databases: Set[Database], keys: Set[ShardingKey]): Set[Database]
}
