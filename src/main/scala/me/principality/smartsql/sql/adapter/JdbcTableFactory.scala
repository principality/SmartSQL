package me.principality.smartsql.sql.adapter

import java.util

import me.principality.smartsql.sql.adapter.table.{JdbcScanTable, JdbcTable}
import org.apache.calcite.rel.`type`.RelDataType
import org.apache.calcite.schema.{SchemaPlus, TableFactory}

/**
  * 如果表是在meta中，需要通过TableFactory创建，否则通过Schema创建
  */
class JdbcTableFactory extends TableFactory[JdbcTable] {
  override def create(schema: SchemaPlus,
                      name: String,
                      operand: util.Map[String, AnyRef],
                      rowType: RelDataType): JdbcTable = {
    new JdbcScanTable
  }
}
