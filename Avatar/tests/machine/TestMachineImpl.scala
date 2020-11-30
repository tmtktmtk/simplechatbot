package machine
import org.junit.Test
import org.junit.Assert._

class TestIntegration {

  // initialisation des objets sous test
  val m = MachineImpl
   m.reinit

  // tests
  @Test
  def test1_1 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Où est donc la Mairie de Rennes?")))
  }
  @Test
  def test2 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("Où est donc")))
  }

  @Test
  def test3 {
    assertEquals(List("Je ne comprends pas votre demande","L'adresse de Gare SNCF est : 19, Place de la Gare"), m.test(List("asda","sGare")))
  }

  @Test
  def test4 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("Je cherche")))

  }

  //F2 requête

  @Test
  def test5 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("hotal de ville")))
  }

  @Test
  def test6 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("mairi")))
  }

  //F3 requête

  @Test
  def test7 {
    assertEquals(List("Bonjour", "L'adresse de Gare SNCF est : 19, Place de la Gare", "Bonjour"), m.test(List("Salut", "Je cherche la gare", "Bonjour")))
  }

  @Test
  def test8 {
    assertEquals(List("Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie", "Je ne comprends pas votre demande"), m.test(List("bonsoir", "hotl de velle", "please")))
  }

  @Test
  def test9 {
    assertEquals(List("Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie", "Je ne comprends pas votre demande"), m.test(List("  bonsoir hotl de velle", "please")))
  }  
  
}
