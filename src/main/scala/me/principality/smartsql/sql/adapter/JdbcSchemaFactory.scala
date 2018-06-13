package me.principality.smartsql.sql.adapter

import java.util

import me.principality.smartsql.sql.sharding.ShardingManagerImpl
import org.apache.calcite.schema.{Schema, SchemaFactory, SchemaPlus}

/**
  * 一个完整的calcite adapter实现，需要包括：
  * 1. SchemaFactory 获取输入参数，完成环境的初始化，并创建Schema
  * 2. Schema 负责创建表，依据SchemaFactory提供的上下文进行表的初始化
  * 3. Table 表的访问接口，功能的实现者
  *
  * 完成以下初始化功能：
  * 1. 完成与后端连接的初始化
  * 2. 把后端连接传递给JdbcSchema
  */
class JdbcSchemaFactory extends SchemaFactory {
  override def create(parentSchema: SchemaPlus, name: String, operand: util.Map[String, AnyRef]): Schema = {
    ShardingManagerImpl(operand.get("urls").asInstanceOf[String], name)
    new JdbcSchema
  }
}
