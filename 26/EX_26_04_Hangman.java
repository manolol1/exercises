/********************************************
* Name:          Mario Ebenhofer
* Date:          15.05. 2024
* HUE:           26
* EX:            04
* Description:   
*********************************************/

import java.util.Scanner;

public class EX_26_04_Hangman {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      final String[] ascii = new ASCII().hangman;
      
      System.out.println(ascii[1]);
   }
}