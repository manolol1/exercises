/********************************************
* Name:           Mario Ebenhofer
* Datum:          13.12.2023
* HUE:            11
* Bsp:            03
* Beschreibung:   Wuerfeln und Statistik ausgeben
*********************************************/

import java.util.Scanner;

public class EX_11_03_Dice {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int maxRollsPerLine = 20;
      int lb = 1;
      int ub = 6;
      
      int amountOfRolls;
      int currRollsInLine = 0;
      int random;
      int currOutput = 0;
      boolean newLine = true;
      
      int ones = 0;
      int twoes = 0;
      int threes = 0;
      int fours = 0;
      int fives = 0;
      int sixes = 0;
      
      System.out.print("Gesamtwuerfe: ");
      amountOfRolls = s.nextInt();
      
      if (amountOfRolls <= 0) {
         System.out.println("Ungueltige Eingabe. Gesamtwuerfe muss groesser als 0 sein!");
         System.exit(0);
      }
      
      for (int i = 0; i < amountOfRolls; i++) {
         random = (int) (Math.random() * (ub - lb + 1) + lb);
         
         if (!newLine) System.out.print(" ");
         System.out.print(random);
         
         newLine = false;
         currRollsInLine++;
         
         if (currRollsInLine >= maxRollsPerLine) {
            System.out.println();
            currRollsInLine = 0;
            newLine = true;
         }
         
         switch (random) {
            case 1:
               ones++;
               break;
            case 2:
               twoes++;
               break;
            case 3:
               threes++;
               break;
            case 4:
               fours++;
               break;
            case 5:
               fives++;
               break;
            case 6:
               sixes++;
               break;
         }
      }
         
      System.out.println("\nStatistik:");
         
      for (int i = 1; i <= ub; i++) {
         switch (i) {
            case 1:
               currOutput = ones;
               System.out.print("1:\t\t\t");
               break;
            case 2:
               currOutput = twoes;
               System.out.print("2:\t\t\t");
               break;
            case 3:
               currOutput = threes;
               System.out.print("3:\t\t\t");
               break;
            case 4:
               currOutput = fours;
               System.out.print("4:\t\t\t");
               break;
            case 5:
               currOutput = fives;
               System.out.print("5:\t\t\t");
               break;
            case 6:
               currOutput = sixes;
               System.out.print("6:\t\t\t");
               break;
         }
         
         System.out.print(currOutput + " x\t");
               
         for (int j = 0; j < currOutput; j++) {
            if (j % 5 == 0) System.out.print(" ");
            System.out.print("|");
         }
         
         System.out.println();
      }
   }
}