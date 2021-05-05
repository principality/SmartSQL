package me.principality.jdbc.table

import org.apache.calcite.rel.`type`.{RelDataType, RelDataTypeFactory}
import org.apache.calcite.schema.impl.AbstractTable


abstract class JdbcTable extends AbstractTable {
  override def getRowType(typeFactory: RelDataTypeFactory): RelDataType = {
    // 实现对meta data的访问
    ???
  }
}
