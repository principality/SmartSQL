package me.principality.smartsql.protocol

import java.net.InetSocketAddress

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.io.{IO, Tcp}
import akka.io.Tcp._
import akka.testkit.{ImplicitSender, TestKit}
import akka.util.ByteString
import akka.testkit.{ImplicitSender, TestActors, TestKit}
import me.principality.smartsql.protocol.mysql.HandshakeResponse
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import scodec.bits.BitVector

import scala.concurrent.duration._

class MySQLActorTest() extends TestKit(ActorSystem("testSystem"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  val clientRef: ActorRef = system.actorOf(Props(classOf[MySQLClient], "127.0.0.1", 33061))

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "Tcp Actor client" must {
    "connect to mysql server" in {
      within(5 seconds) {
        //clientRef ! "hello"
      }
    }
  }

}


class MySQLClient(hostname: String, port: Int) extends Actor {

  import Tcp._
  import context.system
  import scodec.Codec
  import scodec.codecs.implicits._

  val inetSocketAddress = new InetSocketAddress(hostname, port)

  IO(Tcp) ! Connect(inetSocketAddress)

  def receive = {
    case CommandFailed(_: Connect) ⇒
      System.out.println("connect failed")
      context stop self

    case c@Connected(remote, local) ⇒
      val connection = sender()
      connection ! Register(self)
      context become {
        case data: ByteString ⇒
          System.out.println(data)
        case CommandFailed(w: Write) ⇒
          // O/S buffer was full
          System.out.println("write failed")
        case Received(data) ⇒
          System.out.println(data.toString)
          val bits = BitVector.apply(data.toArray)
          val decoded = Codec[HandshakeResponse].decode(bits)
        case "close" ⇒
          connection ! Close
        case _: ConnectionClosed ⇒
          System.out.println("connection closed")
          context stop self
      }

    case s: ByteString ⇒ {
      System.out.println(s)
    }
  }
}