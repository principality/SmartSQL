package me.principality.smartsql.sql.adapter

import org.apache.calcite.schema.Table
import org.apache.calcite.schema.impl.AbstractSchema
import org.apache.calcite.util.Source

class JdbcSchema extends AbstractSchema {
  def createTable(source: Source): Table = ???
}