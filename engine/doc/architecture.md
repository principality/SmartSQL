
# architecture

## High level overview

```
+---------------+    +---------------+    +---------------+
|               |    |               |    |               |
|     query     |    |     query     |    |     query     |
|               |    |               |    |               |
+-------+-------+    +-------+-------+    +-------+-------+
        |                    |                    |  
        |                    |                    |  
+-------v-------+    +-------v-------+    +-------v-------+
|               |    |               |    |               |
|    SmartSQL   |    |    SmartSQL   |    |    SmartSQL   |
|               |    |               |    |               |
+---------------+    +---------------+    +---------------+
|               +---->               +---->               |
|     arrow     |    |     arrow     |    |     arrow     |
|               <----+               <----+               |
+-------+-------+    +-------+-------+    +-------+-------+
        |                    |                    |
        |                    |                    |
+-------v-------+    +-------v-------+    +-------v-------+
|               |    |               |    |               |
|     Store     |    |     Store     |    |     Store     |
|               |    |               |    |               |
+---------------+    +---------------+    +---------------+

```

## 常见存储引擎

存储层提供以下能力：
1. 实时海量数据写入，支持数据更新
2. 分布式存储方案，线性扩展
3. 提供上层的spark connector
4. 提供上层的jdbc driver
5. 提供上层的缓存接口，提升实时应用能力

2018-9

- Kudu ***
- Oracle **
- mysql **
- MS-SQL *
- Postgres **
- MongoDB **
- DB2
- ElasticSearch **
- Redis
- MS-Access
- Cassandra *
- SQLite
- Teradata
- Splunk
- MariaDB *
- Solr *
- Hive *
- HBase **
- SAP Adaptive Server
- FileMaker
- Amazon DynamoDB
