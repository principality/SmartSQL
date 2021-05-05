package me.principality.jdbc.sharding.shard

/**
  * 用于描述分片的规则
  */
trait ShardingRule {

  def fromMeta(meta: Meta)
}
