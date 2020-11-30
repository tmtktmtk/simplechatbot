package reactiveApp

import scala.swing._
import java.awt.Color

class DialogueBox extends TextArea {
  
  //Paramètre du champ d'entrée
  background = Color.WHITE
  foreground = Color.BLUE
  editable = false
  rows = 18
  columns = 30
  lineWrap = true 
  wordWrap = true
  border = Swing.LineBorder(Color.BLUE)
  font = new Font(".AppleSystemUIFont",java.awt.Font.PLAIN, 14)
  
  text = "AVATAR : Bonjour, je suis Avatar. Vous cherchez un lieu sur Rennes ?\nFormulez votre demande comme elle se manifeste !\nJ'y repondrai immediatement.\n"
  
  
  
  
  
  
  

  
}