package me.principality.smartsql.sql.adapter

import org.apache.calcite.config.CalciteConnectionConfig
import org.apache.calcite.rel.`type`.{RelDataType, RelDataTypeFactory}
import org.apache.calcite.schema.impl.AbstractTable
import org.apache.calcite.schema.{Schema, Statistic, Table}
import org.apache.calcite.sql.{SqlCall, SqlNode}

/**
  * 通过实现不同类型的表，优化查询性能
  * https://calcite.apache.org/docs/tutorial.html#optimizing-queries-using-planner-rules
  */
class JdbcTable extends AbstractTable{
  override def getRowType(typeFactory: RelDataTypeFactory): RelDataType = ???
}
