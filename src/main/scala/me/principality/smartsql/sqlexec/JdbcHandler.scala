package me.principality.smartsql.sqlexec

import java.sql.{Connection, DriverManager, ResultSet, Statement}
import java.util.Properties

import scala.io.Source

/**
  * 使用spark对sql进行处理
  *
  * 每客户单actor的模式提供对外的连接服务，actor调用后端的连接池，
  * 由连接池解决后端的调用性能问题，此时每个后端数据源配置一个连接池
  */
class JdbcHandler extends SqlHandler{
  val connection: Connection = {
    ???
  }

  override def execute(sql: String): Option[ResultSet] = {
    val statement: Statement = connection.createStatement
    val resultSet: ResultSet = statement.executeQuery(sql)

    Some(resultSet)
  }
}
