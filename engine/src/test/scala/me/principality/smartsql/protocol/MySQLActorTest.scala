package me.principality.smartsql.protocol

import java.net.InetSocketAddress

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.io.{IO, Tcp}
import akka.testkit.{ImplicitSender, TestKit}
import akka.util.ByteString
import me.principality.smartsql.protocol.mysql.MySQLProtocol.HandshakeV10
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import scodec.bits.BitVector

import scala.concurrent.duration._

/***
  * 需要做一个模拟的客户端，对mysql的协议进行测试
  */
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
        case data: ByteString =>
          System.out.println(data)
        case CommandFailed(w: Write) =>
          // O/S buffer was full
          System.out.println("write failed")
        case Received(data) =>
          System.out.println(data.toString)
          val bits = BitVector.apply(data.toByteBuffer)
          val decoded = Codec[HandshakeV10].decode(bits)
          System.out.println(decoded)
        case "close" =>
          connection ! Close
        case _: ConnectionClosed =>
          System.out.println("connection closed")
          context stop self
      }

    case s: ByteString ⇒ {
      System.out.println(s)
    }
  }
}