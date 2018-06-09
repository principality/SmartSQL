package me.principality.smartsql.sql

import java.sql.ResultSet

/**
  * 对SQL进行：
  * 1、解析
  * 2、优化（转换）
  * 3、生成执行计划
  */
trait SqlHandler {
  def execute(sql: String): Option[ResultSet]
}
