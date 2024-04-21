/********************************************
* Name:          Mario Ebenhofer
* Date:          25.04. 2024
* HUE:           23
* EX:            03
* Description:   "Reach 100" Game
*********************************************/

import java.util.Scanner;

public class EX_23_03_Reach100 {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int PLAYER_COUNT = playerCountInput(s);
      int num = random(1, 30); // determine starting number
      int currPlayer = 1;
      
      System.out.println("Die Zahl ist " + num + "\n");
      
      while (num < 100) { 
         System.out.print("Spieler " + currPlayer + "! Zahl eingeben (>=1, <= 10):\t");
         num += numInput(s, 1, 10);
         System.out.println("Die Zahl ist " + num + "\n");
         
         // move on to next player
         currPlayer %= PLAYER_COUNT;
         currPlayer++;
      }
      
      currPlayer--;
      
      System.out.println("Spieler " + currPlayer + " hat gewonnen!");
   }
   
   private static int playerCountInput(Scanner s) {
      System.out.print("Spielerzahl eingeben: ");
      int players = s.nextInt();
      
      if (players > 1) {
         return players;
      } else {
         System.out.println("Spielerzahl muss > 1 sein!\n");
         return playerCountInput(s); // try again
      }
   }
   
   private static int numInput(Scanner s, int lb, int ub) {
      int input = s.nextInt();
      
      if (input >= lb && input <= ub) {
         return input;
      } else {
         System.out.println("Ungueltige Eingabe!");
         System.out.println("Erneut versuchen: ");
         return numInput(s, lb, ub); // try again
      }
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
   
}
