package me.principality.smartsql.sql.sharding.meta

import me.principality.smartsql.sql.sharding.define.Meta

trait MetaUtils {
  def tableMeta(table: String): Meta
}
