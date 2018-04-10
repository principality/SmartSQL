package me.principality.smartsql.protocol

import org.specs2.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.JdbcBackend

class MySQLSpec extends mutable.Specification {

  private val driver = "org.mariadb.jdbc.Driver" // "com.mysql.jdbc.Driver"
  private val connection = "jdbc:mysql://127.0.0.1:33061/mysql"

  "connect to server" >> {
    val db = JdbcBackend.Database.forURL(connection, driver = driver)
    try {


    } finally db.close()
  }

}
