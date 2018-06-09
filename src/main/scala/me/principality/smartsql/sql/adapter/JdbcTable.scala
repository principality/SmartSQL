package me.principality.smartsql.sql.adapter

import org.apache.calcite.config.CalciteConnectionConfig
import org.apache.calcite.rel.`type`.{RelDataType, RelDataTypeFactory}
import org.apache.calcite.schema.{Schema, Statistic, Table}
import org.apache.calcite.sql.{SqlCall, SqlNode}

class JdbcTable extends Table{
  override def getRowType(typeFactory: RelDataTypeFactory): RelDataType = ???

  override def getStatistic: Statistic = ???

  override def getJdbcTableType: Schema.TableType = ???

  override def isRolledUp(column: String): Boolean = ???

  override def rolledUpColumnValidInsideAgg(column: String, call: SqlCall, parent: SqlNode, config: CalciteConnectionConfig): Boolean = ???
}
