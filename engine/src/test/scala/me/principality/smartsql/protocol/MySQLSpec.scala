package me.principality.smartsql.protocol

import org.specs2.mutable
import slick.jdbc.JdbcBackend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * 通过标准客户端对后端的连接，测试与后端的交互过程是否正确，
  * 正常情况，如果直连的结果与连接后端代理的结果一样，则认为后端通过测试
  */
class MySQLSpec extends mutable.Specification {

  private val driver = "org.mariadb.jdbc.Driver" // "com.mysql.jdbc.Driver"
  private val connection = "jdbc:mysql://127.0.0.1:33062/mysql"

  "a full query process to mysql server" >> {
    val db = JdbcBackend.Database.forURL(connection, driver = driver, user = "root", password = "123456")
    try {
      val query = sql"select host, user from user".as[(String, String)]
      val future = db.run(query)
      future.onComplete{s => println(s)}
    } finally db.close()
    success
  }
}

