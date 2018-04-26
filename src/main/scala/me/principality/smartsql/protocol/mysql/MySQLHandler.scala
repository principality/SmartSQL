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
  *
  * 1. 建立tcp三次握手连接
  * 2. 客户端与服务器建立连接，Connection Phase
  *    s->c 发送握手初始包
  *    c->s 发送验证包
  *    s->c 服务器发送认证结果包
  * 3. 认证通过后，服务器接受客户端命令包并发送响应包，Command Phase
  * 4. 客户端断开连接请求 exit 命令
  * 5. 四次挥手断开连接
  *
  * SQL命令包的解析分为：
  * 1. 完成TCP分包拆包
  * 2. 对完整的包进行解析，提取SQL
  * 3. 调用SQL解析处理器
  */
private[smartsql] class MySQLHandler extends BaseHandler {
  override def handle(packet: ByteString, sender: ActorRef): Unit = {
    // TODO 记得要把packet frame的逻辑加上
    // TODO 对包处理的缓冲机制要仔细考虑，必须注意太多客户端连接导致OOM的问题
  }


  def parsePacket(packet: ByteString): (List[ByteString], ByteString) = {
    ???
  }

  def parseMySQL(packet: ByteString) = {
    ???
  }

  def parseSQL(packet: ByteString) = {
    ???
  }
}
