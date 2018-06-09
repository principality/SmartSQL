package me.principality.smartsql.sql.sharding.define

/**
  * 用于描述分片的规则
  */
trait ShardingRule {

  def fromMeta(meta: Meta)
}
