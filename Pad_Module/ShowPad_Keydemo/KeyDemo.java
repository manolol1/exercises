/* KeyDemo
* 
*  Mag. Holzmann
*
*  Das Programm ermöglicht es, einen Kreis mithilfe der Pfeiltasten zu bewegen.
*/

public class KeyDemo {

   private static Pad pad = new Pad("Key Event Demo");
   private static int x = 190;
   private static int y = 190;

   public static void main(String[] args){
      pad.setLocation(200,150);
      pad.setPadSize(400,400);
      pad.setVisible(true);
      pad.addKeyListener(KeyDemo::keyReleased);
      pad.fillCircle(x, y, 10);
      pad.redraw();
   }

   public static void keyReleased(char keyChar, int keyCode) {
      switch (keyCode) {
         case 37:
            x = (x - 20 + pad.getAreaWidth()) % pad.getAreaWidth();
            break;
         case 38:
            y = (y - 20 + pad.getAreaHeight()) % pad.getAreaHeight();
            break;
         case 39:
            x = (x + 20) % pad.getAreaWidth();
            break;
         case 40:
            y = (y + 20 ) % pad.getAreaHeight();
            break;
      }
      pad.clear();
      pad.fillCircle(x, y, 10);
      pad.redraw();
   }
}

