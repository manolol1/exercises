/* ShowPad_3
* 
*  Musterloesung Mag. Danner
*  Mai 2020
*
*  Das Programm zeichnet zwei Fenster mit je einen Smiley 
*/

import java.awt.*;

public class ShowPad_3{

   public static void main(String[] args){
   
      //Fenster anlegen
      Pad sad = new Pad("trauriger Smiley");
      Pad happy = new Pad("lachender Smiley");
   
            
      //Erstes Fenster einrichten
      sad.setLocation(200,150);
      sad.setPadSize(400,400);
      sad.setBackground(Pad.black);
      sad.setVisible(true);
      
      //Zweites Fenster einrichten
      happy.setLocation(700,150);
      happy.setPadSize(400,400);
      happy.setBackground(Pad.yellow);
      happy.setVisible(true);
   
   
            
      
      //Zeichnen des traurigen Smileys
      sad.setColor(Pad.green);
      sad.fillOval(150,120,30,50);
      sad.fillOval(220,120,30,50);
      sad.setStroke(Pad.wideStroke);
      sad.setColor(Pad.red);
      sad.drawDot(140,250);
      sad.drawDot(142,248);
      sad.drawDot(144,246);
      sad.drawDot(146,244);
      sad.drawDot(148,242);
      sad.drawDot(150,240);
      sad.drawDot(152,238);
      sad.drawDot(154,236);
      sad.drawDot(156,234);
      sad.drawDot(158,232);
      sad.drawDot(160,230);
      sad.drawDot(162,228);
      sad.drawDot(164,226);
      sad.drawDot(166,224);
      sad.drawDot(168,222);
      sad.drawDot(170,220);
      sad.drawDot(172,218);
      sad.drawDot(174,216);
      sad.drawDot(176,214);
      sad.drawDot(178,212);
      sad.drawDot(180,210);
      sad.drawDot(182,208);
      sad.drawDot(184,206);
      sad.drawDot(186,204);
      sad.drawDot(188,202);
      sad.drawDot(190,200);
      sad.drawDot(192,198);
      sad.drawDot(194,196);
      sad.drawDot(196,194);
      sad.drawDot(198,192);
      sad.drawDot(200,190);
      sad.drawDot(202,192);
      sad.drawDot(204,194);
      sad.drawDot(206,196);
      sad.drawDot(208,198);
      sad.drawDot(210,200);
      sad.drawDot(212,202);
      sad.drawDot(214,204);
      sad.drawDot(216,206);
      sad.drawDot(218,208);
      sad.drawDot(220,210);
      sad.drawDot(222,212);
      sad.drawDot(224,214);
      sad.drawDot(226,216);
      sad.drawDot(228,218);
      sad.drawDot(230,220);
      sad.drawDot(232,222);
      sad.drawDot(234,224);
      sad.drawDot(236,226);
      sad.drawDot(238,228);
      sad.drawDot(240,230);
      sad.drawDot(242,232);
      sad.drawDot(244,234);
      sad.drawDot(246,236);
      sad.drawDot(248,238);
      sad.drawDot(250,240);
      sad.drawDot(252,242);
      sad.drawDot(254,244);
      sad.drawDot(256,246);
      sad.drawDot(258,248);
      sad.drawDot(260,248);
   
      sad.redraw();
      
            
      //Zeichnen des froehlichen Smileys mittels Polygon
      happy.setColor(Pad.blue);
      happy.setStroke(Pad.wideStroke);
      Point p1 = new Point(140,120);
      happy.drawCircle(p1,50);
      happy.drawCircle(240,120,50);
      happy.fillCircle(150,150,20);
      happy.fillCircle(260,150,20);
      
      int[] xValues = {130,132,134,136,138,140,142,144,146,148,150,152,154,156,158,160,162,164,166,168,170,172,174,176,178,180,182,184,186,188,190,
                       192,194,196,198,200,202,204,206,208,210,212,214,216,218,220,222,224,226,228,230,232,234,236,238,240,242,244,246,248,250,252,
                       254,256,258,260,262,264,268,270,272,274,276,278,280,282,284,286,288,290,292,294,296,298,300};
                       
      int[] yValues = {180,181,182,183,183,184,185,186,187,187,188,189,190,190,191,192,193,194,194,195,196,197,198,198,199,200,201,202,202,203,204,
                       205,206,206,207,208,209,210,210,210,210,210,210,210,210,210,210,209,208,207,206,206,205,205,203,202,202,201,200,199,198,198,
                       197,196,195,194,194,193,192,191,190,190,189,188,187,186,186,185,184,183,183,182,181,180,180};
                       
      happy.drawPolygon(xValues,yValues);
      happy.setFont(Pad.SERIF,Pad.BOLD,20);
      happy.drawString("Be Happy",50,380);
      happy.redraw();
      
      //Zwinkern
      for (int i = 1; i <= 5; i++){
         sad.setColor(Pad.black);
         sad.fillOval(150,120,30,50);
         sad.redraw();
         try{
            Thread.sleep(300);
         }
         catch (InterruptedException e){
            System.out.println("interrupted");
         }
         sad.setColor(Pad.green);
         sad.fillOval(150,120,30,50);
         sad.redraw();
      
         try{
            Thread.sleep(300);
         }
         catch (InterruptedException e){
            System.out.println("interrupted");
         }
      }
   
   
      
   }
}

