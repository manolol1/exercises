/********************************************
* Name:           Mario Ebenhofer
* Datum:          27.11.2023
* HUE:            09
* Bsp:            01
* Beschreibung:   Kinosaal Reihen und Sitze darstellen
*********************************************/

import java.util.Scanner;

public class EX_09_01_Cinema {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int amountOfRows;
      int seatsPerRow;
      
      int rowCtr = 1;
      int seatCtr = 1;
      
      System.out.print("Reihen: ");
      amountOfRows = s.nextInt();
      
      System.out.print("Sitze: ");
      seatsPerRow = s.nextInt();
      
      System.out.println(amountOfRows + " Reihen mit je " + seatsPerRow + " Sitzen");
      for (int i = 1; i <= amountOfRows; i++) {
         for (int j = 1; j <= seatsPerRow; j++) {
            System.out.print("reihe = " + i + " / sitz = " + j + "\t\t");
         }
         System.out.println();
      }
   }
}