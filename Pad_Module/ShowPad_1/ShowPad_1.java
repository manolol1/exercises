/* ShowPad_1
*  
*  Musterloesung Mag.Danner
*  Mai 2020
*
*  Das Programm erzeugt ein leeres Standardfenster
*/

import java.awt.*;

public class ShowPad_1{

   public static void main(String[] args){
      Pad myFirstWindow = new Pad("Mein erstes Fenster");
      myFirstWindow.setVisible(true);
      myFirstWindow.setColor(Pad.blue);
      myFirstWindow.fillCircle(100,100,30);
   }
}