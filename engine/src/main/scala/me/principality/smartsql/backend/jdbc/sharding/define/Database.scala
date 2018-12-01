package me.principality.smartsql.sqlexec.sharding.define

import java.util.Properties

trait Database {
  def getConnection(props: Properties): Connection
}
