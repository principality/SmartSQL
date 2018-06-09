package me.principality.smartsql.sql

import java.sql.{Connection, DriverManager, ResultSet, Statement}
import java.util.Properties

/**
  * calcite采用jdbc api对外提供访问的接口，此处为使用方法示例。
  * 虽然有calcite内部api，但使用jdbc api有助于接口的规范化。
  *
  * 每客户单actor的模式提供对外的连接服务，actor调用后端的连接池，
  * 由连接池解决后端的调用性能问题，此时每个后端数据源配置一个连接池
  */
class JdbcHandler extends SqlHandler{
  val connection: Connection = {
    Class.forName("org.apache.calcite.jdbc.Driver")

    // meta 初始化，将来通过统一的meta服务获得
    val inputStream = getClass().getClassLoader().getResourceAsStream("model.json")
    val info = new Properties
    info.setProperty("model", inputStream.toString)

    // 连接管理及调用，这里调用calcite，calcite后端实现通过连接池进行优化
    val connection = DriverManager.getConnection("jdbc:calcite:", info)
    connection
  }

  override def execute(sql: String): Option[ResultSet] = {
    val statement: Statement = connection.createStatement
    val resultSet: ResultSet = statement.executeQuery(sql)

    Some(resultSet)
  }
}
