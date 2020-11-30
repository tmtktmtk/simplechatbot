package machine

object MachineImpl extends MachineDialogue {
  
  
  def ask(s: String): List[String] = {
    RqAnalyseImpl.rqProcessor(s).toList
  }
  

  // Pour la partie test par le client
  def reinit = ()
  
  
  def test(l: List[String]): List[String] = {
    val rq = ("" /: l)((x,y) => x +". "+ y)  // transform l to a String
    RqAnalyseImpl.rqProcessor(rq).toList
  }
  
}