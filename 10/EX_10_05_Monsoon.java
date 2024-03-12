/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.12.2023
* HUE:            10
* Bsp:            05
* Beschreibung:   Monsunregen - Regemenge-Tabelle
*********************************************/

import java.util.Scanner;

public class EX_10_05_Monsoon {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int rainyDays = 100;
      
      while (rainyDays < 0 || rainyDays > 90) {
         System.out.print("Regentage: ");
         rainyDays = s.nextInt();
         
         if (rainyDays < 0 || rainyDays > 90) System.out.println("Falsche Tagesanzahl!\n");
      }
      
      if (rainyDays < 30) System.out.println("Starke Ueberschwemmungen");
      if (rainyDays >= 30 && rainyDays < 40) System.out.println("Ueberschwemmungsgefahr");
      if (rainyDays >= 40 && rainyDays < 50) System.out.println("Starkregen");
      if (rainyDays >= 50 && rainyDays < 60) System.out.println("Gute Bodendurchfeuchtung");
      if (rainyDays >= 60 && rainyDays < 70) System.out.println("Ausreichende Bodendurchfeuchtung");
      if (rainyDays >= 70 && rainyDays <= 90) System.out.println("Regen ohne ausreichende Bodenfeuchte");
   }
}