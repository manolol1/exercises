/********************************************
* Name:           Mario Ebenhofer
* Datum:          24.01. 2024
* HUE:            15
* Bsp:            05
* Beschreibung:   
*********************************************/

import java.util.Scanner;

public class EX_15_05_Figure {

   static int spaces = 0;

   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int LB = 9;
      final int UB = 90;
      
      final int BORDER_LB = 1;
      final int BORDER_UB = 10;
      int actualBorderUb = BORDER_UB;
      
      int height = 0;
      int width = 0;
      int border = 0;
      
      String topBottom = "";
      String middle = "";
        
        
      // INPUT //
      
      // height
      while (height < LB || height > UB) {
         System.out.printf("Hoehe (%d - %d):\t", LB, UB);
         height = s.nextInt();
         
         if (height < LB || height > UB) System.out.println("Ungueltige hoehe!\n");
      }
      
      // width
      while (width < LB || width > UB) {
         System.out.printf("Breite (%d - %d):\t", LB, UB);
         width = s.nextInt();
         
         if (width < LB || width > UB) System.out.println("Ungueltige hoehe!\n");
      }
      
      // Calculate border UB
      if (actualBorderUb > height / 3) actualBorderUb = height / 3;
      if (actualBorderUb > width) actualBorderUb = width;
      
      // width
      while (border < BORDER_LB || border > actualBorderUb) {
         System.out.printf("Breite (%d - %d):\t", BORDER_LB, actualBorderUb);
         border = s.nextInt();
         
         if (border < BORDER_LB || border > actualBorderUb) System.out.println("Ungueltige hoehe!\n");
      }
      
     
      // PREPARE LINES //
      
      // Prepare top/bottom line
      topBottom += prepareLine(width, '*');
      
      // Prepare middle line
      middle += prepareLine(border, '*');
      middle += prepareLine(width - (border * 2), ' ');
      middle += prepareLine(border, '*');
      
      
      // OUTPUT //
      
      spaces = height - 1;
      
      System.out.println();
      printLines(border, topBottom);
      printLines(height - border * 2, middle);
      printLines(border, topBottom);
   }
   
   private static String prepareLine(int length, char ch) {
      String line = "";
      for (int i = 0; i < length; i++) {
         line += ch;
      }
      
      return line;
   }
   
   private static void printLines(int numOfLines, String line) {
      for (int i = 0; i < numOfLines; i++) {
         for (int j = 0; j < spaces; j++) {
            System.out.print(" ");
         }
         System.out.println(line);
         spaces--;
      }
   }
}