package reactiveApp

import scala.swing._
import java.awt.Color
import javax.sound.sampled._
import java.io.File;

/**
 * MainFrame realizing the CopyThat application
 */
class UI extends MainFrame {
    
  
  title = "My Avatar friend"
  centerOnScreen()
  preferredSize = new Dimension(400, 200)
  
  // Quelques champs définissant les composants
  
  val input = new EntryField
  val output = new DialogueBox
  val but = new CopyButton("Send",input,output)
  

  // Ajout des composants à la fenêtre

  //contents = new GridPanel(3, 1)/*c marrant*/ {
  contents = new BoxPanel(Orientation.Vertical){
   contents += new Label("Messenger")
   contents += new BoxPanel(Orientation.Vertical){
     contents += output
   }
   contents+= new BoxPanel(Orientation.Horizontal) {

        contents += Swing.HStrut(5)
        contents += input
        contents += but
        contents += Swing.VStrut(20)
   }
     
   }
  }
  