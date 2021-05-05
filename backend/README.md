# backend

考虑支持多种backend，目前有两种实现模式
1. 基于原生的访问接口，如redis/hbase，实现计算引擎与原生接口的对接，并基于原生接口提供计算下推能力
2. 基于calcite jdbc接口，给计算引擎提供统一的jdbc对接

## Design

## Implementation