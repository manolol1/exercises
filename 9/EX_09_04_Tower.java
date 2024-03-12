/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.11.2023
* HUE:            09
* Bsp:            04
* Beschreibung:   Staffelrechnung mit Ausgangszahl
*                 und Anzahl der Berechnungen als Eingabe
*********************************************/

import java.util.Scanner; 

public class EX_09_04_Tower {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int initialNum;
      int numOfCalculations;
      long currResult;
      
      System.out.print("Ausgangszahl: ");
      initialNum = s.nextInt();
      
      System.out.print("Berechnungen: ");
      numOfCalculations = s.nextInt();
      
      currResult = initialNum;
      
      System.out.println("\n");

      for (int i = 2; i < numOfCalculations + 2; i++) {
         System.out.print(currResult + "*" + i + "=\t\t\t");
         currResult *= i;
         System.out.println(currResult);
      }
      
      for (int i = 2; i < numOfCalculations + 2; i++) {
         System.out.print(currResult + "/" + i + "=\t\t\t");
         currResult /= i;
         System.out.println(currResult);
      }
   }
}