# SmartSQL

Distributed middle-ware for MySQL/Postgres

## Why

Add distributed analysis ability to distributed database solution.

分布式的MySQL/Postgres/Storage...的作品，在市面上是有方案的，但是，上述产品在应用于大数据中心时，
缺少分析计算功能，这意味着如果要对分布式的MySQL/Postgres做数据处理，需要在分布式计算框架的基础上，
做一次多数据源的整合处理后，再进行计算。

毫无疑问，上述过程导致了处理速度的延迟，以及提升了系统的复杂度。

SmartSQL的定位在于在现有的分布式OLTP的基础上，增加计算的功能，从而可以满足某些OLTP+OLAP混合的应用场景，
实现智能分析和在线事务的一体化处理。
