package me.principality.smartsql.backend.jdbc

import java.util

import me.principality.smartsql.backend.jdbc.table.{JdbcScanableTable, JdbcTable}
import me.principality.smartsql.sqlexec.adapter.table.{JdbcScanableTable, JdbcTable}
import org.apache.calcite.rel.`type`.RelDataType
import org.apache.calcite.schema.{SchemaPlus, TableFactory}


class JdbcTableFactory extends TableFactory[JdbcTable] {
  override def create(schema: SchemaPlus,
                      name: String,
                      operand: util.Map[String, AnyRef],
                      rowType: RelDataType): JdbcTable = {
    new JdbcScanableTable
  }
}
