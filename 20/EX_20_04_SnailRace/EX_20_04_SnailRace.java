/********************************************
* Name:           Mario Ebenhofer
* Datum:          20.03. 2024
* HUE:            20
* Bsp:            04
* Beschreibung:   Schneckenrennen
* Zusätzliche Klassen: Player.java, Constants.java
*********************************************/

import java.util.Scanner;
import java.lang.*;

public class EX_20_04_SnailRace {
   public static void main(String[] args) throws InterruptedException{
      Scanner s = new Scanner(System.in);
      
      final int PLAYER_NUMBER;
      
      clearScreen();
      
      System.out.println("   _____  _____ _    _ _   _ ______ _____ _  ________ _   _ _____  ______ _   _ _   _ ______ _   _ ");
      System.out.println("  / ____|/ ____| |  | | \\ | |  ____/ ____| |/ /  ____| \\ | |  __ \\|  ____| \\ | | \\ | |  ____| \\ | |");
      System.out.println(" | (___ | |    | |__| |  \\| | |__ | |    | ' /| |__  |  \\| | |__) | |__  |  \\| |  \\| | |__  |  \\| |");
      System.out.println("  \\___ \\| |    |  __  | . ` |  __|| |    |  < |  __| | . ` |  _  /|  __| | . ` | . ` |  __| | . ` |");
      System.out.println("  ____) | |____| |  | | |\\  | |___| |____| . \\| |____| |\\  | | \\ \\| |____| |\\  | |\\  | |____| |\\  |");
      System.out.println(" |_____/ \\_____|_|  |_|_| \\_|______\\_____|_|\\_\\______|_| \\_|_|  \\_\\______|_| \\_|_| \\_|______|_| \\_|\n\n");
      
      PLAYER_NUMBER = playerNumber(s);
      clearScreen();
      
      Player[] players = new Player[PLAYER_NUMBER];
      s.nextLine(); // remove last return from key buffer
      
      // create new players
      for (int i = 0; i < PLAYER_NUMBER; i++) {
         players[i] = new Player(i);
      }
      
      while (true) {
         for (int i = 0; i < PLAYER_NUMBER; i++) {
            clearScreen();
            printField(players);
            System.out.println("\nSpieler " + i + " ist dran.");
            System.out.println("Druecke Enter zum wuerfeln!");
            s.nextLine();
            
            clearScreen();
            players[i].roll();

            System.out.println();
            printField(players);
            System.out.println("\nDuecke Enter, um fortzufahren.");
            s.nextLine();
            
            if (players[i].getPosition() >= Constants.FIELD_SIZE - 1) {
               clearScreen();
               printField(players);
               System.out.println("Spieler " + i + " hat gewonnen!");
               System.out.println("Das Spiel wird beendet.");
               System.exit(0);
            }
         }
      }
   }
   
   private static int playerNumber(Scanner s) {
      int players = 0;
      System.out.print("Spielerzahl (2-6): ");
      players = s.nextInt();
      
      if (players >= 2 && players <= 6) {
         return players;
      } else {
         System.out.println("Ungueltige Eingabe!\n");
         return playerNumber(s); // try again
      }
   }
   
   private static void printField(Player[] players) {
      for (int i = 0; i < players.length; i++) {
         players[i].printField();
      }
   }
   
   private static void clearScreen() {
      // "clears" the screen by simply printing a lot of empty lines.
      // Not optimal but clearing the java console seems to be pretty difficult,
      // especially if it should work on multiple operating systems.
      System.out.println(System.lineSeparator().repeat(100));
   }
}