package me.principality.jdbc.sharding.merge

trait ResultSetMerger {
  def merge(sets: Iterable[ResultSet])
}
