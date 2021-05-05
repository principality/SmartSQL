package me.principality.jdbc.sharding.shard

/**
  * 不需要考虑master-slave的方案，对绝大多数的数据库来说，都有现成的方案，这里只考虑分库分表
  *
  * 分库常见算法：以表名路由
  * 分表常见算法：
  * - 根据键值Hash分布
  * - 根据键值范围分片
  */
trait ShardingRouter {

}
