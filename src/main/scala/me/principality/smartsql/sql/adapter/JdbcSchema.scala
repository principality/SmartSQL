package me.principality.smartsql.sql.adapter

import java.util

import org.apache.calcite.linq4j.tree.Expression
import org.apache.calcite.schema
import org.apache.calcite.schema._

class JdbcSchema extends Schema {
  override def getTable(name: String): Table = ???

  override def getTableNames: util.Set[String] = ???

  override def getFunctions(name: String): util.Collection[schema.Function] = ???

  override def getFunctionNames: util.Set[String] = ???

  override def getSubSchema(name: String): Schema = ???

  override def getSubSchemaNames: util.Set[String] = ???

  override def getExpression(parentSchema: SchemaPlus, name: String): Expression = ???

  override def isMutable: Boolean = ???

  override def snapshot(version: SchemaVersion): Schema = ???
}
