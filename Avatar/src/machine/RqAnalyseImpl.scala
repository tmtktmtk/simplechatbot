package machine

object RqAnalyseImpl extends AnalyseRq {

  val dsb = new Database("doc//DonneesInitiales.txt")
  val greet = List("bonjour", "salut", "yo", "hi", "hey", "hello","bonsoir")
  
  val motFR = List("bonjour","salut","bonsoir","recherche","cherche","ou","est","donc","trouve","trouver","français")
  val motANG = List("hi","hello","morning","evening","afternoon","hey","seek","seeking","search","searching","look","looking","where","find","english")
  val motESP = List("hola","buenos","dias","donde","esta","busco","buscando","español")
  val motALL = List("hallo","guten","morgen","tag","abend","wo","ist","suche","suchen","deutsch")
  val motITA = List("buongiorno","ciao","salve","buon","pomeriggio","buonasera","incantato","dove","trova","cerco","cercando","italiano")
  
  
  def rqProcessor(rq: String): Array[String] = {  
    var res = Array[String]() 
    val phrases = phraseSeparator(rq)
    for(v<-phrases) res = res ++ respond(v)  
    res    
  }
  
  private def keyWordsSeparator(rq: String): Array[String] = {
    var res = rq.split(" ")
    res = FormeNormaleImpl.normalise(res)
    LevenshteinMethod.check(res, dsb.DB._1)
  }
  

  private def respond(rq: String): Array[String] = {
    def isInGreet(s: String): Boolean = ((999 /: greet)((x, y) => Math.min(LevenshteinMethod.LevenshteinDistance(s, y), x)) < 2)
    def disBjr(s: String): Boolean = {
      val mots = s.split(" ")
      (false /: mots)((x, y) => x || isInGreet(y))
    }
//    analyseLangue(rq) match {
//      case 1 => return Array("Parlez vous français ?")
//      case 2 => return Array("Do you speak english ?")
//      case 3 => return Array("¿Hablas español?")
//      case 4 => return Array("Sprechen Sie Deutsch?")
//      case 5 => return Array("Va bene, qual è la tua richiesta?")
//    } 
    rq match {
      case x if isInGreet(x) => Array("Bonjour")
      case x => {
        var rep = Array[String]()
        if (disBjr(x)) rep=rep :+ "Bonjour"
        val indexOfRes = indexBD(keyWordsSeparator(x).dropWhile(y => greet.contains(y)))
        indexOfRes.length match {
          case 0 => rep = rep :+ "Je ne comprends pas votre demande"
          case 1 => rep = rep :+ "L'adresse de "+dsb.DB._2(indexOfRes(0))+" est : "+dsb.DB._3(indexOfRes(0))
          case x => {
            rep = rep :+ "Il y a "+x+" réponses possibles:"
            for(idx <- 0 to x-1) rep = rep :+ "L'adresse de "+dsb.DB._2(indexOfRes(idx))+" est : "+dsb.DB._3(indexOfRes(idx))+"."
          }
        }
        rep
      }
    }
  }
  
  private def phraseSeparator(rq: String) : Array[String] = {
    var res = rq.split("[,;.?!:]")
    FormeNormaleImpl.normalise(res)
  }
  
  private def indexBD(l: Array[String]): Array[Int] = {
    
   def noMatch(l1: Array[String],l2: Array[Array[String]]) : Array[Int] = {
     var res = new Array[Int](l2.length)
     for(i<- 0 to res.length - 1) res(i) = l1.intersect(l2(i)).length
     res
   }
   
   
   val nMatch = noMatch(l,dsb.DB._1)
   var res = Array[Int]()
   val maxMatch = nMatch.max

   for(i <- 0 to nMatch.length-1) if(maxMatch!=0 && nMatch(i)==maxMatch) res = res :+ i

   res
  }
  
  private def analyseLangue(rq:String): Int = {
     if((false /: motFR)((x,y) => x || rq.contains(y))){ return 1 }
     if((false /: motANG)((x,y) => x || rq.contains(y))) { return 2 }
     if((false /: motESP)((x,y) => x || rq.contains(y))){ return 3 }
     if((false /: motALL)((x,y) => x || rq.contains(y))){ return 4 }
     if((false /: motITA)((x,y) => x || rq.contains(y))){ return 5 }
     return 0
   }

}