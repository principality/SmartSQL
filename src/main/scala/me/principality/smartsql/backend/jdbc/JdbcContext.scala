package me.principality.smartsql.backend.jdbc

case class JdbcContext(urls: Seq[String], name: String)

object JdbcContext {
    private var instance: JdbcContext = null

    def apply(urls: String, schemaName: String) = {
      if (null == instance) instance = new JdbcContext(urls.split(";"), schemaName)
      instance
    }
}

