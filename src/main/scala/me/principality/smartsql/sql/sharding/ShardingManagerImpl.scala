package me.principality.smartsql.sql.sharding

import me.principality.smartsql.sql.sharding.define._

/**
  * 基于slick实现后端的查询
  */
class ShardingManagerImpl extends ShardingManager
  with ShardingStrategy
  with ResultSetMerger {

  override def execute(sql: String): ResultSet = ???

  override def doShard(databases: Set[Database], keys: Set[ShardingKey]): Set[Database] = ???

  override def merge(sets: Iterable[ResultSet]): Unit = ???

  override def apply(rule: ShardingRule): Unit = ???
}
