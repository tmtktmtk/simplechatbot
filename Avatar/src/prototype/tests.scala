package prototype
import machine._

object tests extends App {

//  database.listBD("doc\\DonneesInitiales.txt").foreach(println)

//  val rq = "bonJour je VouDrais chércher la Marie de Rennes"

//  var a = LanguageProcessor.RqAnalyse(rq)
//
//  a.foreach(println)
//
//  for(i<- 0 to a.length-1 ) {
//   a(i) = WordVerifier.formeNormale(a(i))
//  }
//  WordVerifier.connecteurRemover(a).foreach(println)

//  filterCorrector.dsb._1.foreach(_.foreach(println))

//  val s1="marie"
//  val s2 = "gare"
//  println(filterCorrector.verifyHammingDistance(s1, s2))

//  val testcheck = Array("jess", "cherche", "mairie", "desss", "rennes")

//  filterCorrector.check(testcheck).foreach(println)
//  languageProcessor.numberOfMatch(testcheck).foreach(println)
//  println(testcheck.count(_=="rennes"))

//  filterCorrector.dsb._1.foreach(_.foreach(println))
  
//  RqAnalyseImpl.phraseSeparator("Bonjour, ou se trouve la mairie?, scsdgar??").foreach(println)
//  println(RqAnalyseImpl.disBjr(", ou se trouve la bonjour mairie?, scsdgar??"))

  var s = "      Bojour   ,    ou      se    trouve la mgare   ?,    scsdgar    ??    "
//  val as = RqAnalyseImpl.phraseSeparator(s)
//  for(v <- as) {
//    RqAnalyseImpl.rqProcessor(v).foreach(println)
//  }
//  as.foreach(println)
  
//  LevenshteinMethod.check(RqAnalyseImpl.phraseSeparator(s), RqAnalyseImpl.dsb.DB._1).foreach(println)
  
//  s= s.trim().replaceAll("[ ]{3,}", "")
//
//  println(s)
  
//  val array1 = Array(1,2,3,4,5,6,7,8,9)
//  val array2 = Array(4,5,6,11,111)
//  RqAnalyseImpl.dsb.DB._1.foreach(_.foreach(println))
  
  var array = Array("ou","se","trouve","la","not existe")
//  RqAnalyseImpl.indexBD(array).foreach(println)
  
//  println(("" /: array)((x,y) => x + y))
  
  val dsb = new Database("doc//DonneesInitiales.txt")
  
}