/********************************************
* Name:          Mario Ebenhofer
* Date:          25.04. 2024
* HUE:           23
* EX:            02
* Description:   Vigenere encryption and decryption
*********************************************/

public class EX_23_02_Vigenere {
   public static void main(String[] args){
      String k = "SECURITY";
      String str = encrypt("WHITEHATBLACKHAT", k);
      System.out.println(str);
      str = decrypt(str, k);
      System.out.println(str);
   }
   
   private static String encrypt(String plainText, String keyString) {
      return vigenere(plainText, keyString, 0);
   }
   
   private static String decrypt(String plainText, String keyString) {
      return vigenere(plainText, keyString, 1);
   }
   
   private static String vigenere(String plainText, String keyString, int mode) {
      StringBuilder result = new StringBuilder(plainText.length());
      
      char[] plainAr = plainText.toCharArray();
      char[] keyAr = keyString.toCharArray();
      
      for (int i = 0; i < plainAr.length; i++) {
         char plainCh = plainAr[i];
         char keyCh = keyAr[i % keyAr.length];
         
         int plainOffset = Character.isUpperCase(plainCh) ? 'A' : 'a';
         int keyOffset = Character.isUpperCase(keyCh) ? 'A' : 'a';
         
         int key = keyCh - keyOffset;
         
         if (mode == 1) {
            key *= -1;
         }
         
         if (plainCh >= plainOffset && plainCh <= plainOffset + 26) {
            result.append((char) (((plainCh - plainOffset + key + 26) % 26) + plainOffset));
         } else {
            result.append(plainCh);
         }
      }
      
      return result.toString();
   }
}
