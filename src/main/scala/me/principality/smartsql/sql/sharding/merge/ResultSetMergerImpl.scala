package me.principality.smartsql.sql.sharding.merge

import me.principality.smartsql.sql.sharding.define.{ResultSetMerger, ResultSet}

class ResultSetMergerImpl extends ResultSetMerger {
  override def merge(sets: Iterable[ResultSet]): Unit = ???
}
