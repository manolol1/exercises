/********************************************
* Name:           Mario Ebenhofer
* Datum:          17.01. 2024
* HUE:            14
* Bsp:            04
* Beschreibung:   Spiel
*********************************************/

import java.util.Scanner;
import java.util.Random;

public class EX_14_04_RockPaperScissors {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      Random random = new Random();
      
      int pointsToWin = 0;
      
      int player = -1;
      int computer;
      
      int playerPoints = 0;
      int computerPoints = 0;
      
      System.out.println("Schere (1) - Papier (2) - Stein (3)");
      
      while (pointsToWin < 1) {
         System.out.print("Siegerpunkte: ");
         pointsToWin = s.nextInt();
         
         if (pointsToWin < 1) {
            System.out.println("Siegerpunkte muss groesser als 0 sein!\n");
         }
      }
      
      for (int i = 0; i < pointsToWin; i++) {
         player = -1;
         while (player < 1 || player > 3) {
            System.out.print("\n\tSpieler 1:\t\t");
            player = s.nextInt();
            
            if (player < 1 || player > 3) System.out.println("Ungueltige Eingabe!");
         }
         
         player--;
         
         computer = random.nextInt(3);
         System.out.println("\tComputer:\t\t" + (computer + 1));
         
         if (player == computer) {
            System.out.println("Unentschieden.");
         } else {
            if ((3 + computer - player) % 3 == 1) {
               System.out.println("Punkt fuer Spieler 1.");
               playerPoints++;
            } else {
               System.out.println("Punkt fuer Computer.");
               computerPoints++;
            }
         }
      }
      
      System.out.println();
      
      if (playerPoints == computerPoints) {
         System.out.println("Unentschieden.");
      } else {
         System.out.println((playerPoints < computerPoints ? "Computer" : "Spieler 1") + " gewinnt.");
      }
   }
}