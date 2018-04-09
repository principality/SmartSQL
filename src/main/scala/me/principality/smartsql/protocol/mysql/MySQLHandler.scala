package me.principality.smartsql.protocol.mysql

import akka.actor.ActorRef
import akka.util.ByteString
import me.principality.smartsql.protocol.BaseHandler

/**
  * MySQL协议处理
  *
  * MySQL客户端GPL授权的原因，建议使用 MariaDB Connector/J
  * https://downloads.mariadb.org/connector-java/+releases/
  * https://mariadb.com/kb/en/library/about-mariadb-connector-j/
  *
  * 或者采取开源的方式，使用MySQL Connector/J，也不会有问题，
  * 关于GPL的进一步解释，可上网搜索获得
  * https://stackoverflow.com/questions/620696/mysql-licensing-and-gpl
  *
  * 下面是关于MySQL的协议说明：
  * https://dev.mysql.com/doc/internals/en/client-server-protocol.html
  * http://hutaow.com/blog/2013/11/06/mysql-protocol-analysis/
  */
private[smartsql] class MySQLHandler extends BaseHandler {
  override def handle(packet: ByteString, sender: ActorRef): Unit = {
    // TODO 记得要把packet frame的逻辑加上
    // TODO 对包处理的缓冲机制要仔细考虑
  }
}
