package me.principality.smartsql.backend.jdbc.table

import org.apache.calcite.DataContext
import org.apache.calcite.linq4j.Enumerable
import org.apache.calcite.schema.ScannableTable

class JdbcScanableTable extends JdbcTable with ScannableTable {
  override def scan(root: DataContext): Enumerable[Array[AnyRef]] = {
    ???
  }

}
