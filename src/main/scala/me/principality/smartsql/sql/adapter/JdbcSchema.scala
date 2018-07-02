package me.principality.smartsql.sql.adapter

import me.principality.smartsql.sql.adapter.table.JdbcScanableTable
import org.apache.calcite.schema.Table
import org.apache.calcite.schema.impl.AbstractSchema
import org.apache.calcite.util.Source

/**
  * 根据不同的配置，初始化生成不同类型的表，Calcite对没有配置的Table采用Schema进行创建
  */
class JdbcSchema extends AbstractSchema {
  def createTable(source: Source): Table = {
    new JdbcScanableTable
  }
}
