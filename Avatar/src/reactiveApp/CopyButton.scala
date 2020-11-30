package reactiveApp

import scala.swing._
import event._
import machine._
import javax.sound.sampled._
import java.io.File;

/** A button for realizing a text-copy
 * @param lab the label of the button
 * @param from the Infield from which the text is copied
 * @param to the ResultText to which the text is copied
 */

class CopyButton(lab: String, from : EntryField, to : DialogueBox) extends Button {

	text = lab
	var i = 0
	
	// Fonction permettant de jouer un son
	
  val send = new File("./sons/envoye.wav")
  def soundEffect(son: File): Unit = {
   val clip : Clip = AudioSystem.getClip()
   clip.open(AudioSystem.getAudioInputStream(son))
   clip.start()
  }
	

	def listStringToString(l: List[String]) : String = {
			l match {
			case Nil => ""
			case x::y => x+ " "+listStringToString(y)
			}
	}
	// Ajout d'une reaction au clic sur le bouton
	// c'est à dire copier le contenu du champ from dans le label de to.
	reactions += {
	case ButtonClicked(_) => { soundEffect(send);if(i < 3){
		to.text = to.text +  "\n"/* saut de ligne */ + "me : " + from.text  + "      " + "\nAvatar : " + listStringToString(MachineImpl.ask(from.text))
		from.text = ""//reset
		i=i+1
		}
		else  {
		  i=0
		  to.text =  "\n"/* saut de ligne */ + "me : " + from.text  + "      " + "\nAvatar : " + listStringToString(MachineImpl.ask(from.text))
		
		from.text = ""//reset
		}
	}
	} 
}