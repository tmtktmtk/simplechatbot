package machine

object FormeNormaleImpl extends FormeNormale {

  def normalise(l: Array[String]): Array[String] = {
    var res = l
    for (i <- 0 to res.length - 1) {
      res(i) = accentsRemover(res(i))
    }
    res = connecteurRemover(res)
    res
  }

  private def connecteurRemover(as: Array[String]): Array[String] = {
    val motsdeliason: List[String] = List("de", "dans", "le", "la", "car", "que", "par", ""," ")
    as.filterNot(x => motsdeliason.contains(x))
  }

  private def accentsRemover(s: String): String = {
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
    res.toLowerCase().trim().replaceAll("[ ]{2,}"," ")
  }

}