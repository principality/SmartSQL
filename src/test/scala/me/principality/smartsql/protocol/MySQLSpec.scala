package me.principality.smartsql.protocol

import java.net.InetSocketAddress

import akka.actor.{Actor, Props}
import akka.io.{IO, Tcp}
import akka.util.ByteString
import org.specs2.mutable

import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.JdbcBackend
import slick.jdbc.MySQLProfile.api._

class MySQLSpec extends mutable.Specification {

  private val driver = "org.mariadb.jdbc.Driver" // "com.mysql.jdbc.Driver"
  private val connection = "jdbc:mysql://127.0.0.1:33061/mysql"

  "connect to server" >> {
    val db = JdbcBackend.Database.forURL(connection, driver = driver, user = "root", password = "123456")
    try {
      val query = sql"select host, user from user".as[(String, String)]
      val future = db.run(query)
      future.onComplete{s => println(s)}
    } finally db.close()
    success
  }
}

