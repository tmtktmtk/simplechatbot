package prototype

import machine.MachineDialogue

object machineImplPrototype extends MachineDialogue {
  def ask(s: String): List[String] = {
    var res = Array[String]()
    if (languageProcessor.Greeting(s)) {
      res = res :+ "Bonjour."
    }
    val as = languageProcessor.RqAnalyse(s)
    val noMatch = languageProcessor.numberOfMatch(as)
    val nbMaxMatch = noMatch.count(x => x == noMatch.max)
    var indexDSB: Int = 0
    if (noMatch.max != 0) {
      if (nbMaxMatch == 1) {
        indexDSB = noMatch.indexOf(noMatch.max)
        res = res :+ filterCorrector.dsb._2(indexDSB) + ": " + filterCorrector.dsb._3(indexDSB) + "."
      } else {
        println("Veuillez affiner votre recherche")
        //reinit()
      }
    } else res = res :+ "not found in dsb."

    res.toList
  }

  // Pour la partie test par le client
  def reinit = ???
  def test(l: List[String]): List[String] = ???
}