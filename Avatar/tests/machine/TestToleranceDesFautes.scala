package machine
import org.junit.Test
import org.junit.Assert._

class TestToleranceDesFautes {
  

  val m = LevenshteinMethod
 

  @Test
  def test1 {
    assertEquals((0), m.LevenshteinDistance("mairie", "mairie"))
  }
  
  
   @Test
  def test2{
    assertEquals((-1), m.LevenshteinDistance("mirie", "maire"))
  }
 
   @Test
  def test3 {
    assertEquals((0), m.LevenshteinDistance("mairie", "mairie"))
  }
 
  
}