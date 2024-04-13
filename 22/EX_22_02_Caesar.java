/********************************************
* Name:          Mario Ebenhofer
* Date:          10.04. 2024
* HUE:           22
* EX:            02
* Description:   Caesar Cypher (encrypt and decrypt)
*********************************************/

import java.util.Scanner;

public class EX_22_02_Caesar {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      // test encrypt() and decrypt() with a random String
      int k = -3;
      String str = encrypt("Hallo ABCD XYZ ?", k);
      System.out.println(str);
      str = decrypt(str, k);
      System.out.println(str);
   }
   
   private static String encrypt(String plainText, int key) {
      key %= 26;
      
      StringBuilder result = new StringBuilder(plainText.length());
      
      for (char ch : plainText.toCharArray()) {
         int offset = Character.isUpperCase(ch) ? 'A' : 'a';
         
         if (ch >= offset && ch <= offset + 26) {
            result.append((char) (((ch - offset + key + 26) % 26) + offset));
         } else {
            result.append(ch);
         }
      }
      
      return result.toString();
   }
   
   private static String decrypt(String encryptedText, int key) {
      key %= 26;
      return encrypt(encryptedText, -key);
   }
}
