package prototype
import scala.io.Source
import scala.util.control.Breaks._

object languageProcessor {

  def RqAnalyse(rq: String): Array[String] = {
    var as = rq.split(Array(',', ' ', '.', ':', ';'))
    as = WordVerifier.formeNormale(as)
    filterCorrector.check(as)
  }

  def Greeting(s: String): Boolean = {
    val greet = List("bonjour", "salut", "yo", "hi", "hey", "hello","bonsoir")
    var boo = false
    var as = s.split(Array(',', ' ', '.', ':', ';'))
    for (i <- 0 to as.length - 1) {
      boo = boo || greet.contains(as(i))
    }
    boo
  }

  def numberOfMatch(as: Array[String]): Array[Int] = {
    val keywords = filterCorrector.dsb._1
    var res = new Array[Int](keywords.length)
    for (i <- 0 to keywords.length - 1) {
      for (j <- 0 to as.length - 1) {
        res(i) = res(i) + keywords(i).count(_ == as(j))
      }
    }
    res
  }

}

//verify with DSB, if Hamming Distance = 1 replace it with the right key else if Hamming distance !=0 remove from the list
// TODO need to be changed
object filterCorrector {

  val dsb = dsbPrototype.listBD("doc//DonneesInitiales.txt")

  def verifyHammingDistance(s1: String, s2: String): Int = {
    val length = Math.min(s1.length() - 1, s2.length() - 1)
    if (Math.abs(s1.length() - s2.length()) > 1) -1 else {
      var count = 0
      for (i <- 0 to length) {
        if (s1.charAt(i).equals(s2.charAt(i))) count = count + 1
      }
      Math.abs(count - (length + 1))
    }
  }

  def check(as: Array[String]): Array[String] = {
    var res = Array[String]()
    for (i <- 0 to as.length - 1) {
      for (j <- 0 to dsb._1.length - 1) {
        for (k <- 0 to dsb._1(j).length - 1) {
          val hd = verifyHammingDistance(as(i), dsb._1(j)(k))
          //          println(as(i) +"   " + dsb._1(j)(k)+"    " +verifyHammingDistance(as(i),dsb._1(j)(k)) )
          if (hd == 0 || hd == 1) {
            res = res :+ dsb._1(j)(k)

          }
        }
      }
    }
    res
  }

}

object dsbPrototype {

  def listBD(path: String): (Array[Array[String]], Array[String], Array[String]) = {
    var keys = Array[String]()
    var values = Array[String]()
    val ligne: Array[String] = Source.fromFile(path).getLines.toArray
    for (i <- ligne) {
      val isplit = i.split(";")
      keys = keys :+ isplit(0)
      values = values :+ (isplit(1))
    }
    var arrayKeysWords = Array[Array[String]]()

    for (i <- 0 to keys.length - 1) {
      arrayKeysWords = arrayKeysWords :+ WordVerifier.formeNormale(keys(i).split(' '))
    }

    (arrayKeysWords, keys, values)
  }

}

object WordVerifier {

  def formeNormale(as: Array[String]): Array[String] = {
    var res = as

    for (i <- 0 to res.length - 1) {
      res(i) = WordVerifier.accentsRemover(res(i))
    }
    res = WordVerifier.connecteurRemover(res)
    res
  }

  def connecteurRemover(as: Array[String]): Array[String] = {
    val motsdeliason: List[String] = List("de", "dans", "le", "la", "car", "que", "par", " ","")
    as.filterNot(x => motsdeliason.contains(x))
  }

  def accentsRemover(s: String): String = {
    val accents: Map[String, String] = Map(
      ("é", "e"),
      ("è", "e"),
      ("ê", "e"),
      ("ë", "e"),
      ("à", "a"),
      ("â", "a"),
      ("ä", "a"),
      ("ù", "u"),
      ("û", "u"),
      ("ü", "u"),
      ("î", "i"),
      ("ï", "i"),
      ("ô", "o"),
      ("ö", "o"),
      ("ç", "c"))
    var res: String = ""
    for (c <- s) {
      if (accents.contains(c.toString)) res += accents.get(c.toString).get
      else res += c
    }
    res.toLowerCase()
  }

}