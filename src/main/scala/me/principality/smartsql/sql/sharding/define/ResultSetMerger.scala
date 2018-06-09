package me.principality.smartsql.sql.sharding.define

trait ResultSetMerger {
  def merge(sets: Iterable[ResultSet])
}
