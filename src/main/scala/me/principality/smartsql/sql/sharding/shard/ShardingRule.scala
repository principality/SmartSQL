package me.principality.smartsql.sql.sharding.shard

import me.principality.smartsql.sql.sharding.meta.Meta

/**
  * 用于描述分片的规则
  */
trait ShardingRule {

  def fromMeta(meta: Meta)
}
