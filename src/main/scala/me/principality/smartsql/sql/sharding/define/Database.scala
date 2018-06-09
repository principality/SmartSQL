package me.principality.smartsql.sql.sharding.define

import java.util.Properties

trait Database {
  def getConnection(props: Properties): Connection
}
