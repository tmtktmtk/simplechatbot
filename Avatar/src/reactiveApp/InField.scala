package reactiveApp

import scala.swing._
import java.awt.Color

/**
 * Customized textfArea receiving the input text to copy 
 */
class InField extends TextArea {

  tabSize_= (5)
  background = Color.GRAY
  foreground = Color.WHITE
  text = ""
  border = Swing.LineBorder(Color.GRAY)
  
}