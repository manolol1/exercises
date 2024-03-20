/********************************************
* Name:           Mario Ebenhofer
* Datum:          20.03. 2024
* HUE:            20
* Bsp:            04
* Beschreibung:   Schneckenrennen
*********************************************/

import java.util.Scanner;
import java.lang.*;

public class EX_20_04_SnailRace {
   public static void main(String[] args) throws InterruptedException{
      Scanner s = new Scanner(System.in);
      
      final int PLAYER_NUMBER;
      
      clearScreen();
      
      // ASCII-art (looks very weird as code or on paper but normal in the console)
      System.out.println("   _____  _____ _    _ _   _ ______ _____ _  ________ _   _ _____  ______ _   _ _   _ ______ _   _ ");
      System.out.println("  / ____|/ ____| |  | | \\ | |  ____/ ____| |/ /  ____| \\ | |  __ \\|  ____| \\ | | \\ | |  ____| \\ | |");
      System.out.println(" | (___ | |    | |__| |  \\| | |__ | |    | ' /| |__  |  \\| | |__) | |__  |  \\| |  \\| | |__  |  \\| |");
      System.out.println("  \\___ \\| |    |  __  | . ` |  __|| |    |  < |  __| | . ` |  _  /|  __| | . ` | . ` |  __| | . ` |");
      System.out.println("  ____) | |____| |  | | |\\  | |___| |____| . \\| |____| |\\  | | \\ \\| |____| |\\  | |\\  | |____| |\\  |");
      System.out.println(" |_____/ \\_____|_|  |_|_| \\_|______\\_____|_|\\_\\______|_| \\_|_|  \\_\\______|_| \\_|_| \\_|______|_| \\_|\n\n");
      
      PLAYER_NUMBER = playerNumber(s);
      clearScreen();
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
   
   private static void clearScreen() {
      // "clears" the screen by simply printing a lot of empty lines.
      // Not optimal but clearing the java console seems to be pretty difficult,
      // especially if it should work on multiple operating systems.
      System.out.println(System.lineSeparator().repeat(100));
   }
}