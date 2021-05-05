package me.principality.jdbc.sharding.meta

trait MetaUtils {
  def tableMeta(table: String): Meta
}
