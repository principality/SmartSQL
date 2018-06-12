package me.principality.smartsql.sql.sharding

import me.principality.smartsql.sql.sharding.define._
import slick.jdbc.JdbcBackend

/**
  * 基于slick实现后端的查询
  */
class ShardingManagerImpl(val urls: String, val schemaName: String) extends ShardingManager
  with ShardingStrategy
  with ResultSetMerger {

  val driver = "org.mariadb.jdbc.Driver" // "com.mysql.jdbc.Driver"
  val dbs = urls.split(";")
    .map(url => JdbcBackend.Database.forURL(url+schemaName, driver = driver, user = "root", password = "123456"))

  override def execute(sql: String): ResultSet = ???

  override def doShard(databases: Set[Database], keys: Set[ShardingKey]): Set[Database] = ???

  override def merge(sets: Iterable[ResultSet]): Unit = ???

  override def init(rule: ShardingRule): Unit = ???
}

object ShardingManagerImpl {
  private var instance: ShardingManagerImpl = null

  def apply(urls: String, schemaName: String) = {
    if (null == instance) instance = new ShardingManagerImpl(urls, schemaName)
    instance
  }

  def execute(sql: String): ResultSet = instance.execute(sql)
}