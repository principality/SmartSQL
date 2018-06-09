package me.principality.smartsql.sql.adapter

import java.util

import org.apache.calcite.schema.{Schema, SchemaFactory, SchemaPlus}

/**
  * 一个完整的calcite adapter实现，需要包括：
  * 1.
  */
class JdbcSchemaFactory extends SchemaFactory {
  override def create(parentSchema: SchemaPlus, name: String, operand: util.Map[String, AnyRef]): Schema = {
    ???
  }
}
