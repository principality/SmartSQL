package me.principality.smartsql.sql.sharding.merge

trait ResultSetMerger {
  def merge(sets: Iterable[ResultSet])
}
