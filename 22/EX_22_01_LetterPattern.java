/********************************************
* Name:          Mario Ebenhofer
* Date:          10.04. 2024
* HUE:           22
* EX:            01
* Description:   Patterns
*********************************************/

import java.util.Scanner;

public class EX_22_01_LetterPattern {
   public static void main(String[] args){
      final int MAX_ROW = 4;
      final int N = getInput();
      
      System.out.println("ANFANG MUSTER 1");
      for (int i = 0; i < N; i++) {
         for (int j = 0; j <= i; j++) {
            System.out.print((char) ('A' + i));
         }
         System.out.println();
      }
      System.out.println("ENDE MUSTER 1\n");
      
      
      System.out.println("ANFANG MUSTER 2");
      for (int i = 0; i < N; i++) {
         for (int j = 0; j <= i % MAX_ROW; j++) {
            System.out.print((char) ('A' + i));
         }
         System.out.println();
      }
      System.out.println("ENDE MUSTER 2");
   }
   
   private static int getInput() {
      final int LB = 5, UB = 26;
      Scanner s = new Scanner(System.in);
      
      int in = LB - 1;
      
      System.out.printf("Obergrenze (%d-%d): ", LB, UB);
      in = s.nextInt();
      
      if (in >= LB && in <= UB) {
         System.out.println();
         return in;
      } else {
         System.out.println("Ungueltig!!!\n");
         return getInput();
      }
   }
}
