package me.principality.smartsql.sql.adapter.table

import java.util

import org.apache.calcite.DataContext
import org.apache.calcite.linq4j.Enumerable
import org.apache.calcite.rex.RexNode
import org.apache.calcite.schema.ProjectableFilterableTable

class JdbcProjectableFilterableTable  extends JdbcTable with ProjectableFilterableTable {
  override def scan(root: DataContext,
                    filters: util.List[RexNode],
                    projects: Array[Int]): Enumerable[Array[AnyRef]] = {
    ???
  }
}
