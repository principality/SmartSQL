package me.principality.smartsql.sql.adapter

import me.principality.smartsql.sql.adapter.table.JdbcScanTable
import org.apache.calcite.schema.Table
import org.apache.calcite.schema.impl.AbstractSchema
import org.apache.calcite.util.Source

/**
  * 根据不同的配置，初始化生成不同类型的表
  */
class JdbcSchema extends AbstractSchema {
  def createTable(source: Source): Table = {
    new JdbcScanTable
  }
}
