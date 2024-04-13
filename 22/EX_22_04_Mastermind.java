/********************************************
* Name:          Mario Ebenhofer
* Date:          10.04. 2024
* HUE:           22
* EX:            04
* Description:   Mastermind (game)
*********************************************/

import java.util.Scanner;

public class EX_22_04_Mastermind {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      final int LENGTH = 4, LB = 1, UB = 6;
      
      int[] correct = randomUniqueArray(LENGTH, LB, UB);
   }
   
   private static int[] randomUniqueArray(int length, int lb, int ub) {
      // check, if generating that array is even possible (avoid infinite loop)
      if ((ub - lb + 1) < length) {
         System.out.println("ERROR: Could not generate unique array - not enough possible numbers");
         System.exit(1);
      }
      
      int[] ar = new int[length];
      int random = 0;
      boolean unique;
      
      for (int i = 0; i < length; i++) {
         unique = false;
         
         while (!unique) {
            random = random(lb, ub);
            unique = true;
            
            for (int j = 0; j < i; j++) {
               if (ar[j] == random) {
                  unique = false;
                  break;
               }
               unique = true;
            }
         }
         
         ar[i] = random;
      }
      
      return ar;
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
}
