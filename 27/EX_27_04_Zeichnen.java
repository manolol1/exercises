/********************************************
* Name:          Mario Ebenhofer
* Date:          21.05. 2024
* HUE:           27
* EX:            04
* Description:   Experimenting with the Pad-Module
* Additional Class: Pad.java
*********************************************/

/* Changes inside Pad.java
   
   Fixed:
      NullPointerException at getHeight() (Line ~240)
      
   Added:
      getWidth()
      centerWindow()
      enabled Antialiasing
*/

import java.awt.*;
import java.awt.event.*;

public class EX_27_04_Zeichnen {
  
   static Pad pad;
   static int state = 0;
  
   public static void main(String[] args) {
      pad = new Pad("Hello World!");
      pad.setPadSize(800, 800);
      pad.centerWindow();
      pad.setVisible(true);
            
      final String notice = "Press Enter to change painting!";
      pad.setFont(pad.SANSSERIF, pad.BOLD, 35);
      pad.drawString(notice, 400 - pad.stringWidth(notice) / 2, 400);
      System.out.println(notice);
      
      pad.addKeyListener(
         (character, keyCode) -> {
            if (keyCode == KeyEvent.VK_ENTER) {
               switch (state) {
                  case 0:
                     face();
                     break;
                  case 1:
                     tree();
                     break;
               }
            
               state++;
               if (state > 1) {
                  state = 0;
               }
            }
         });
   }
   
   private static void face() {
      pad.clear();
      pad.setColor(12, 123, 55);
      pad.fillCircle(400, 400, 300);
      
      pad.setColor(pad.black);
      
      pad.fillCircle(280, 300, 60); // left eye
      pad.fillCircle(520, 300, 60); // right eye
      
      pad.setStroke(pad.wideStroke);
      pad.drawLine(250, 500, 550, 500); // mouth
      
      pad.redraw();
   }
   
   private static void tree() {
      pad.clear();
      
      // trunk
      pad.setColor(139,69,19);
      pad.fillRect(350, 400, 100, 800);
      
      // top
      pad.setColor(12, 123, 55);
      pad.fillCircle(400, 300, 200);
      
      pad.redraw();
   }
}
