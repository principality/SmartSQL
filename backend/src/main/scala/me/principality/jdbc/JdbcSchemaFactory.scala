package me.principality.jdbc

import java.util

import org.apache.calcite.schema.{Schema, SchemaFactory, SchemaPlus}


class JdbcSchemaFactory extends SchemaFactory {
  override def create(parentSchema: SchemaPlus, name: String, operand: util.Map[String, AnyRef]): Schema = {
    JdbcContext(operand.get("urls").asInstanceOf[String], name)
    new JdbcSchema
  }
}
