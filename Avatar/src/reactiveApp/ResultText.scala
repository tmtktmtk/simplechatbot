package reactiveApp

import scala.swing._
import java.awt.Color

/**
 * Customized label receiving the copied text 
 */
class ResultText extends TextArea {
  background = Color.BLACK
  foreground = Color.WHITE
  text = "ask me anything !"
  
}