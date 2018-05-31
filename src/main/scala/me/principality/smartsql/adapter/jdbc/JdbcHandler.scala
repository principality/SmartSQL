package me.principality.smartsql.adapter.jdbc

import java.sql.DriverManager
import java.util.Properties

import me.principality.smartsql.sql.SqlHandler

class JdbcHandler extends SqlHandler{
  override def execute(sql: String): Unit = {

    Class.forName("org.apache.calcite.jdbc.Driver")

    val info = new Properties
//    info.setProperty("lex", "JAVA")
    val connection = DriverManager.getConnection("jdbc:calcite:", info)
    Class.forName("com.mysql.jdbc.Driver")
    val statement = connection.createStatement
    val resultSet = statement.executeQuery(sql)
    resultSet.close()
    statement.close
  }
}
