/********************************************
* Name:           Mario Ebenhofer
* Datum:          17.01. 2024
* HUE:            14
* Bsp:            02
* Beschreibung:   Lotto Zahlen
*********************************************/

import java.util.Scanner;

public class EX_14_02_Lotto {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int inputLb = 10;
      int inputUb = 50;
      int lb = 1;
      int ub = inputLb - 1;
      
      boolean numbersDifferent;
      
      int[] numbers = new int[6];
      
      while (ub < inputLb || ub > inputUb) {
         System.out.print("Obergrenze eingeben (" + inputLb + "-" + inputUb + "): ");
         ub = s.nextInt();
         
         if (ub < inputLb || ub > inputUb) System.out.println("Ungueltige Obergrenze!!!\n");
      }
      
      System.out.print("Zahlen: ");
      
      for (int i = 0; i < 6; i++) {
         numbersDifferent = false;
         numbers[i] = (int) (Math.random() * ub - lb + 1) + lb;
         
         // Make sure that all numbers are different
         while (!numbersDifferent) {
            numbersDifferent = true;
            for (int j = 0; j < 6; j++) {
               if (numbers[i] == numbers[j] && i != j) {
                  numbers[i] = (int) (Math.random() * ub - lb + 1) + lb;
                  numbersDifferent = false;
               }
            }
         }
         
         // Output
         switch (i) {
            case 0: 
               System.out.print(numbers[i]);
               break;
            case 5: 
               System.out.print(" und " + numbers[i] + ".");
               break;
            default: System.out.print(", " + numbers[i]);
         }
      }
   }
}