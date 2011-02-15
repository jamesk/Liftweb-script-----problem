package ajaxscript.testblockui {
package snippet {

import _root_.scala.xml.{NodeSeq, Text}
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.java.util.Date
import ajaxscript.testblockui.lib._
import Helpers._

import _root_.net.liftweb.http._
import S._
import SHtml._
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import Helpers._
import _root_.scala.xml._
import _root_.net.liftweb.http.js._
import net.liftweb.http.js.jquery.JqJsCmds.ModalDialog
import net.liftweb.http.js.jquery.JqJsCmds.Unblock
import JsCmds.Alert
import JsCmds.SetHtml
import JsCmds.Noop

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  val somevalue = "A string of odd chars  !\"£$%^&*(){} :@~#';?><,./ and the whammy ]]> text"
  
  val somecmd = Alert(somevalue) 
  val someraw = JE.JsRaw("alert(" + somevalue.encJs.replace(">", "\\u003e") + ")")
  
  val someelem = <span>{JsCmds.Script(if (S.param("work").isDefined) someraw.cmd else somecmd)}</span>
  				
  // bind the date into the element with id "time"
  def howdy = "#time *" #> someelem

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

}
}
