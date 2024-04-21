/********************************************
* Name:          Mario Ebenhofer
* Date:          25.04. 2024
* HUE:           23
* EX:            01
* Description:   Encryption with numbers
                 Letters (A-Z) are represented as 1 - 26
                 Space is represented by 0
                 Other Characters are ignored.
*********************************************/

public class EX_23_01_LetterNumber {
   final static int GROUP_SIZE = 4;
   
   public static void main(String[] args){
      // test with some random string
      String msg = "Das ist eine Nachricht! ABC";
      System.out.println(msg);
      String encrypted = encrypt(msg);
      System.out.println(encrypted);
      System.out.println(decrypt(encrypted));
   }
   
   private static String encrypt(String input) {
      input = input.toUpperCase();
      StringBuilder message = new StringBuilder(input.length() * 2 + input.length() / GROUP_SIZE);
      char[] inputAr = input.toCharArray();
      
      for (int i = 0; i <= inputAr.length - 1; i++) {
         char ch = inputAr[i];
         int code = 0;
         
         // add space for number groups
         if (i % GROUP_SIZE == 0 && i != 0) {
            message.append(" ");
         }
         
         // only encrypt char if it is an actual letter
         if (ch >= 'A' && ch <= 'Z') {
            code = ch - 'A' + 1;
         } else if (ch == ' ') {
            code = 0;
         } else {
            message.append(ch); // ignore special characters
            continue;
         }
         
         message.append(String.format("%02d", code));
      }
      
      return message.toString();
   }
   
   private static String decrypt(String input) {
      StringBuilder message = new StringBuilder(input.length() / 2 + 1);
      
      input = input.replaceAll(" ", ""); // remove spaces
      
      char[] inputAr = input.toCharArray();
      
      int i = 0;
      while (i < inputAr.length) {
         if (Character.isDigit(inputAr[i])) {
            String str = inputAr[i] + "" + inputAr[i + 1]; // get the next two-digit number
            int n = Integer.valueOf(str);
            if (n == 0) {
               message.append(" ");
            } else {
               message.append((char) (n + 'A' - 1));
            }
            
            i += 2; // move on to next number
         } else {
            message.append(input.charAt(i));
            i++; // skip special characters
         }
      }
      
      return message.toString();
   }
}
