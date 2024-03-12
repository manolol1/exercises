/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.11.2023
* HUE:            09
* Bsp:            04
* Beschreibung:   Staffelrechnung mit ausgangszahl
*                 und Zahl der Berechnungen als Eingabe
*                 Erweiterung mit BigInteger fuer unendlich grosse Zahlen.
*********************************************/

import java.util.Scanner;
import java.math.BigInteger;

public class EX_09_04_Tower_BigInt {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int initialNum;
      int numOfCalculations;
      BigInteger currResult = new BigInteger("0");
      
      System.out.print("Ausgangszahl: ");
      initialNum = s.nextInt();
      
      System.out.print("Berechnungen: ");
      numOfCalculations = s.nextInt();
      
      currResult = new BigInteger("" + initialNum);
      
      System.out.println("\n");
   
      for (int i = 2; i < numOfCalculations + 2; i++) {
         System.out.print(currResult + "*" + i + "=\t\t\t");
         currResult = currResult.multiply(new BigInteger("" + i));
         System.out.println(currResult);
      }
      
      for (int i = 2; i < numOfCalculations + 2; i++) {
         System.out.print(currResult + "/" + i + "=\t\t\t");
         currResult = currResult.divide(new BigInteger("" + i));
         System.out.println(currResult.toString());
      }
   }
}