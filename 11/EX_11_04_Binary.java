/********************************************
* Name:           Mario Ebenhofer
* Datum:          13.12.2023
* HUE:            11
* Bsp:            04
* Beschreibung:   Dezimalzahl -> Binaerzahl
*********************************************/

import java.util.Scanner;

public class EX_11_04_Binary {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int inputLb = 15;
      final int inputUb = 1500;
      
      int decimalInput = 0;
      boolean inputPending = true;
      
      String binary = "";
      int decimal;
      
      // Input
      while (inputPending) {
         System.out.print("Dezimalzahl eingeben (" + inputLb + "-" + inputUb + "): ");
         decimalInput = s.nextInt();
         
         if (decimalInput >= inputLb && decimalInput <= inputUb) {
            inputPending = false;
         } else {
            System.out.println("Ungueltige Eingabe!");
            System.out.println("Die Zahl muss zwischen " + inputLb + " und " + inputUb + " liegen.\n");
         }
      }
      
      decimal = decimalInput;
      
      // Convert decimal number to binary
      while (decimal > 0) {
         binary = decimal % 2 + binary;
         decimal /= 2;
      }
      
      System.out.println("Die Zahl " + decimalInput + " lautet binaer " + binary + ".");
      
      // Kuerzere Alternative:
      // System.out.println(Integer.toBinaryString(decimalInput));  
   }
}