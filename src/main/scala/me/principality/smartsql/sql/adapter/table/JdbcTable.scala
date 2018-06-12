package me.principality.smartsql.sql.adapter.table

import org.apache.calcite.DataContext
import org.apache.calcite.linq4j.Enumerable
import org.apache.calcite.rel.`type`.{RelDataType, RelDataTypeFactory}
import org.apache.calcite.schema.ScannableTable
import org.apache.calcite.schema.impl.AbstractTable

/**
  * 通过实现不同类型的表，优化查询性能
  * https://calcite.apache.org/docs/tutorial.html#optimizing-queries-using-planner-rules
  *
  * org.apache.calcite.schema 定义了几种常见的表
  *   org.apache.calcite.schema.ExtensibleTable
  *   org.apache.calcite.schema.FilterableTable
  *   org.apache.calcite.schema.ModifiableTable
  *   org.apache.calcite.schema.ProjectableFilterableTable
  *   org.apache.calcite.schema.QueryableTable
  *   org.apache.calcite.schema.ScannableTable
  *   org.apache.calcite.schema.StreamableTable
  *   org.apache.calcite.schema.TranslatableTable
  *
  * 关注：FilterableTable, ProjectableFilterableTable, QueryableTable, ScannableTable, TranslatableTable
  *
  * adapter负责对接calcite，最终的实现通过sharding来完成
  */
abstract class JdbcTable extends AbstractTable {

  override def getRowType(typeFactory: RelDataTypeFactory): RelDataType = {
    // 实现对meta data的访问
    ???
  }
}
