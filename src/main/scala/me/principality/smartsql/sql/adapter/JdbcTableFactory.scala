package me.principality.smartsql.sql.adapter

import java.util

import org.apache.calcite.rel.`type`.RelDataType
import org.apache.calcite.schema.{SchemaPlus, TableFactory}

class JdbcTableFactory extends TableFactory[JdbcTable] {
  override def create(schema: SchemaPlus,
                      name: String,
                      operand: util.Map[String, AnyRef],
                      rowType: RelDataType): JdbcTable = {
    new JdbcTable
  }
}
