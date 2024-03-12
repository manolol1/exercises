/********************************************
* Name:           Mario Ebenhofer
* Datum:          29.11.2023
* HUE:            09
* Bsp:            06
* Beschreibung:   Multiplikationstabelle
*********************************************/

public class EX_09_06_Multiply {
   public static void main(String[] args){
      int lb = 1;
      int ub = 10;
      
      
      // MULTIPLICATION //
      
      // Table Header
      System.out.print("*");
      for (int i = lb; i <= ub; i++) {
         System.out.print("\t\t" + i);
      }
      
      System.out.println();
      
      for (int i = lb; i <= ub; i++) {
         System.out.print(i);
         for (int j = lb; j <= ub; j++) {
            System.out.print("\t\t" + i * j);
         }
         
         System.out.println();
      }
      
      System.out.println("\n");
      
      
      // ADDITION //
      
      // Table Header
      System.out.print("+");
      for (int i = lb; i <= ub; i++) {
         System.out.print("\t\t" + i);
      }
      
      System.out.println();
      
      for (int i = lb; i <= ub; i++) {
         System.out.print(i);
         for (int j = lb; j <= ub; j++) {
            System.out.print("\t\t" + (i + j));
         }
         
         System.out.println();
      }
      
      System.out.println("\n");
   }
}