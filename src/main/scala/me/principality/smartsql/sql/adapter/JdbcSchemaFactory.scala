package me.principality.smartsql.sql.adapter

import java.util

import org.apache.calcite.schema.{Schema, SchemaFactory, SchemaPlus}

/**
  * 一个完整的calcite adapter实现，需要包括：
  * 1. SchemaFactory 获取输入参数完成Schema初始化
  * 2. Schema 负责创建表
  * 3. Table 表的访问接口
  *
  * 如果需要进一步的功能，则需要
  */
class JdbcSchemaFactory extends SchemaFactory {
  override def create(parentSchema: SchemaPlus, name: String, operand: util.Map[String, AnyRef]): Schema = {
    ???
  }
}
