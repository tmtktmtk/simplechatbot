package machine
import scala.io.Source

class Database(path: String) extends BaseDeDonnees {

  val DB = listBD(path)

  def listBD(path: String): (Array[Array[String]], Array[String], Array[String]) = {
    var keys = Array[String]()
    var values = Array[String]()
    var arrayKeyWords = Array[Array[String]]()
    val ligne: Array[String] = Source.fromFile(path).getLines.toArray
    for (i <- ligne) {
      val isplit = i.split(";")
      keys = keys :+ isplit(0)
      values = values :+ (isplit(1))
      arrayKeyWords = arrayKeyWords :+ FormeNormaleImpl.normalise(isplit(2).split(" "))
    }
    
    for (i <- 0 to keys.length - 1) {
      arrayKeyWords(i) = (arrayKeyWords(i)++FormeNormaleImpl.normalise(keys(i).split(' '))).distinct
    }

    (arrayKeyWords, keys, values)
  }
}