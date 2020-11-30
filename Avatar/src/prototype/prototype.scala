package prototype
import scala.io.StdIn._
import machine._

object prototype extends App {
  var rq = ""
  println("write a request")
  rq = readLine()
  MachineImpl.ask(rq).foreach(println)
}