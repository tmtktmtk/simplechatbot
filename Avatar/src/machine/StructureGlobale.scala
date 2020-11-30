package machine

trait BaseDeDonnees {

  /**
   * A partir d'un fichier texte, permet de créer un objet BaseDeDonnées
   * @param path chemin du fichier texte
   * @return res une base de données sous la forme List[String, String]
   */
  def listBD(path: String): (Array[Array[String]], Array[String], Array[String])
}

trait ToleranceDesFautes {
  /**
   * Verifier et corriger les fautes dans une requete
   * @param rq une requete sous forme Array[String]
   * @param dsb list des mots cles dans la base de donnee
   * @return un Array[String] verifie'
   */
  def check(rq: Array[String], dsb: Array[Array[String]]): Array[String]
}

trait FormeNormale {

  /**
   * Retourner un Array[String] en minuscule, sans accents, sans mots de liason
   * @param list des mots Array[String]
   * @return list normalise'
   */
  def normalise(l: Array[String]): Array[String]
}

trait AnalyseRq {

  /**
   * A partir d'un String de requete permet d'avoir un Array des mots cles sous forme normale
   * @param rq une requete
   * @return list de responses
   */
  def rqProcessor(rq: String): Array[String]

}