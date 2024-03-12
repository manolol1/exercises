/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          25.10.2023
* HUE:            06
* Bsp:            06
* Beschreibung:   Pruefen, ob eine Zahl im vorgegebenen Bereich liegt
************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class Ex_06_06_Inputcheck {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int lb;
      int ub;
      int num;
      
      System.out.print("Untergrenze: ");
      lb = s.nextInt();
      System.out.print("Obergrenze: ");
      ub = s.nextInt();
      
      if (lb > ub) {
         System.out.println("\nFehlerhafte Eingabe.");
         System.out.println("Die Untergrenze darf nicht groesser als die Obergrenze sein!");
         System.exit(0);
      }
      
      System.out.print("Zahl: ");
      num = s.nextInt();
      
      if (num >= lb && num <= ub){
         System.out.println("Die Zahl " + num + " liegt im vorgegebenen Bereich zwischen " + lb + " und " + ub + ".");
      }
      else if (num < lb) {
         System.out.println("Die Zahl " + num + " ist zu klein fuer den vorgegebenen Bereich zwischen " + lb + " und " + ub + ".");
      } else{
         System.out.println("Die Zahl " + num + " ist zu gross fuer den vorgegebenen Bereich zwischen " + lb + " und " + ub + ".");
      }
   }
}