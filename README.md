# SmartSQL

Distributed middle-ware for MySQL/Postgres

## Why

Add distributed analysis ability to distributed database solution.

分布式的MySQL/Postgres/Storage...在市面上是有方案的，但是，在应用于大数据中心时，
结合分析计算的分布式方案，则很缺少。

这意味着如果要在业务上实现分布式事务，同时支持分布式计算，则需要构建两套系统，
一套用于分布式事务，一套用于分布式计算。

毫无疑问，上述架构导致了提升了系统的复杂度，增加了开发和应用的难度。

SmartSQL的定位在于在分布式OLTP方案的基础上，增加计算的功能，从而满足OLTP+OLAP混合的应用场景，
实现智能分析和在线事务的一体化处理。

## RoadMap

V0.1的开发重点是：
1. 实现对查询的支持（暂不考虑数据操作）
2. 索引加速，中间结果缓存
3. 对接前端查询界面
4. 分析计算功能

解决单机的计算能力不足，是第一版的目标

V0.2 ?