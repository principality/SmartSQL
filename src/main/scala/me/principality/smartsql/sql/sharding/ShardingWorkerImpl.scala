package me.principality.smartsql.sql.sharding

import me.principality.smartsql.sql.sharding.define._
import slick.jdbc.JdbcBackend

/**
  * 基于slick实现后端的查询
  */
class ShardingWorkerImpl(val urls: Seq[String], val schemaName: String) extends ShardingWorker
  with ShardingStrategy
  with ResultSetMerger
  with AutoCloseable {

  val driver = "org.mariadb.jdbc.Driver" // "com.mysql.jdbc.Driver"
  val user = "root"
  val password = "123456"
  val dbs = urls
    .map(url => JdbcBackend.Database.forURL(url + schemaName,
      driver = driver, user = user, password = password))

  override def execute(sql: String): ResultSet = ???

  override def doShard(databases: Set[Database], keys: Set[ShardingKey]): Set[Database] = ???

  override def merge(sets: Iterable[ResultSet]): Unit = ???

  override def init(rule: ShardingRule): Unit = ???

  override def close(): Unit = {
    for (db <- dbs) {
      db.close()
    }
  }
}