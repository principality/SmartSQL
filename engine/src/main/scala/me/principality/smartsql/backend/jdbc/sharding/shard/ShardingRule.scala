package me.principality.smartsql.sqlexec.sharding.shard

import me.principality.smartsql.sqlexec.sharding.meta.Meta

/**
  * 用于描述分片的规则
  */
trait ShardingRule {

  def fromMeta(meta: Meta)
}
