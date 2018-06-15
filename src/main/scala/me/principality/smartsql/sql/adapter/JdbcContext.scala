package me.principality.smartsql.sql.adapter

case class JdbcContext(urls: Seq[String], name: String)

object JdbcContext {
    private var instance: JdbcContext = null

    def apply(urls: String, schemaName: String) = {
      if (null == instance) instance = new JdbcContext(urls.split(";"), schemaName)
      instance
    }
}

