package me.principality.jdbc

import me.principality.jdbc.table.JdbcScanableTable
import org.apache.calcite.schema.Table
import org.apache.calcite.schema.impl.AbstractSchema
import org.apache.calcite.util.Source


class JdbcSchema extends AbstractSchema {
  def createTable(source: Source): Table = {
    new JdbcScanableTable
  }
}
