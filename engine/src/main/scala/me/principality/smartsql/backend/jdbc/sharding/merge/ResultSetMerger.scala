package me.principality.smartsql.sqlexec.sharding.merge

trait ResultSetMerger {
  def merge(sets: Iterable[ResultSet])
}
