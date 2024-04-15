/********************************************
* Name:          Mario Ebenhofer
* Date:          25.04. 2024
* HUE:           23
* EX:            01
* Description:   Encryption with numbers
*********************************************/

import java.util.Scanner;

public class EX_23_01_LetterNumber {
   final static int GROUP_SIZE = 4;
   
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      System.out.println(encrypt("Das"));
   }
   
   private static String encrypt(String input) {
      input = input.toUpperCase();
      StringBuilder message = new StringBuilder(input.length() * 2 + input.length() / GROUP_SIZE);
      
      for (char ch : input.toCharArray()) {
         message.append(ch - 'A');
      }
      
      return message.toString();
   }
}
