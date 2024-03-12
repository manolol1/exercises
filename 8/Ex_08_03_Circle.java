/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          15.11.2023
* HUE:            08
* Bsp:            03
* Beschreibung:   Umfang und Flaeche von Kreisen
************************************************************/

public class Ex_08_03_Circle {
   public static void main(String[] args) {
      int lb = 1;
      int ub = 10;
      int radiusCtr;
      
      radiusCtr = lb;
      
      // Table header
      System.out.println("Radius\t\tUmfang\t\t\t\t\tFlaeche");
      
      while (radiusCtr <= ub) {
         
         // Radius
         System.out.print(radiusCtr + "\t\t\t\t");
         
         // Circumference
         System.out.print(2 * radiusCtr * Math.PI + "\t\t");
         
         // Area
         System.out.print(radiusCtr * radiusCtr * Math.PI);
         
         System.out.println();
         radiusCtr++;
      }
   }
}