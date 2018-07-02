package me.principality.smartsql.extension.Index

/**
  * 实现对索引的支撑，使用akka-distributed-data作为支撑
  */
trait IndexService {
  def putIndex[A](table: String, column: String, value: Any, id: A) = ???
  def getIndex[A](table: String, column: String, value: Any): A = ???
}
