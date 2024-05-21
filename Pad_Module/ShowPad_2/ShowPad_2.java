/* ShowPad_2
*
*  Musterloesung Mag. Danner
*  Mai 2020
*
*  Das Programm definiert unterschiedliche Veränderungen des Standardfensters
*/

import java.awt.*;

public class ShowPad_2{

   public static void main(String[] args){
   
      Pad myWindow = new Pad();
      myWindow.setLocation(500,150);
     
      myWindow.setBackground(Pad.lightYellow);
      myWindow.setPadSize(400,400); 
      myWindow.setTitle("Ein selbst gestaltetes Fenster");
        
      myWindow.setVisible(true);
      
      System.out.println("Sie sehen eine Zeichenflaeche der Hoehe " + myWindow.getAreaHeight() + " und Breite " + myWindow.getAreaWidth());
   }
}