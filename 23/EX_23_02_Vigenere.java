/********************************************
* Name:          Mario Ebenhofer
* Date:          25.04. 2024
* HUE:           23
* EX:            02
* Description:   Vigenere encryption and decryption
*********************************************/

public class EX_23_02_Vigenere {
   public static void main(String[] args){
      String k = "ABC";
      String str = encrypt("Pinguine sind sehr tolle Tiere.", k);
      System.out.println(str);
      str = decrypt(str, k);
      System.out.println(str);
   }
   
   // "wrapper methods" for encrypting and decrypting
   private static String encrypt(String plainText, String keyString) {
      return vigenere(plainText, keyString, 0);
   }
   
   private static String decrypt(String plainText, String keyString) {
      return vigenere(plainText, keyString, 1);
   }
   
   // mode 0 for encryption, any other number for decryption
   private static String vigenere(String plainText, String keyString, int mode) {
      StringBuilder result = new StringBuilder(plainText.length());
      
      keyString = prepareKey(keyString);
      
      char[] plainAr = plainText.toCharArray();
      char[] keyAr = keyString.toCharArray();
      
      for (int i = 0; i < plainAr.length; i++) {
         char plainCh = plainAr[i];
         char keyCh = keyAr[i % keyAr.length];
         
         int plainOffset = Character.isUpperCase(plainCh) ? 'A' : 'a';
         int keyOffset = Character.isUpperCase(keyCh) ? 'A' : 'a';
         
         int key = keyCh - keyOffset + 1;
         
         if (mode != 0) {
            key *= -1;
         }
         
         // only encrypt letters from A-Z, ignore any other characters
         if (plainCh >= plainOffset && plainCh <= plainOffset + 26) {
            result.append((char) (((plainCh - plainOffset + key + 26) % 26) + plainOffset));
         } else {
            result.append(plainCh);
         }
      }
      
      return result.toString();
   }
   
   // make sure that the key only contains letters
   private static String prepareKey(String keyString) {
      StringBuilder result = new StringBuilder(keyString.length());
      for (char ch : keyString.toCharArray()) {
         if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            result.append(ch);
         }
      }
      return result.toString();
   }
}
