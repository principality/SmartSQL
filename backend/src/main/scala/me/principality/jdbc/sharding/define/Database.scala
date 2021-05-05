package me.principality.jdbc.sharding.define

import java.util.Properties

trait Database {
  def getConnection(props: Properties): Connection
}
