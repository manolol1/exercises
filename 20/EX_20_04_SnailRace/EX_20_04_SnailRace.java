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
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      final int PLAYER_NUMBER;
      
      int round = 0;
      
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
         round++;
         for (int i = 0; i < PLAYER_NUMBER; i++) {
            clearScreen(round);
            System.out.println("\nSpieler " + i + " ist dran.");
            System.out.println("Druecke Enter zum wuerfeln!\n");
            printField(players);
            s.nextLine();
            
            clearScreen(round);
            players[i].roll();

            System.out.println("\nDruecke Enter, um fortzufahren.\n");
            printField(players);
            s.nextLine();
            
            if (players[i].getPosition() >= Constants.FIELD_SIZE - 1) {
               clearScreen(round);
               System.out.println("Spieler " + i + " hat gewonnen!");
               System.out.println("Das Spiel wird beendet.\n");
               printField(players);
               System.exit(0);
            }
         }
      }
   }
   
   private static int playerNumber(Scanner s) {
      int players = 0;
      System.out.print("Spielerzahl (2-8): ");
      players = s.nextInt();
      
      if (players >= 2 && players <= 8) {
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
      System.out.println(System.lineSeparator().repeat(100));
   }
   
   private static void clearScreen(int round) {
      System.out.println(System.lineSeparator().repeat(100));
      System.out.println("[RUNDE " + round + "]\n");
   }
}