/********************************************
* Name:           Mario Ebenhofer
* Datum:          03.04. 2024
* HUE:            21
* Bsp:            01
* Beschreibung:   Feststellen, ob ein Satz ein Palindrom ist.
*********************************************/

public class EX_21_01_Palindrome {
   public static void main(String[] args){
      final String INPUT = "Madam, I'm Adam";
      String preparedInput = prepareString(INPUT);
      
      String reversed = reverseString(preparedInput);
      
      System.out.println("\"" + INPUT + "\" ist " + (preparedInput.equals(reversed) ? "ein" : "kein") + " Palindrom");
   }
   
   private static String prepareString(String in) {
      StringBuilder result = new StringBuilder(in.length());
      
      for (int i = 0; i < in.length(); i++) {
         if (isLetter(in.charAt(i))) {
            result.append(in.charAt(i));
         }
      }
      
      return result.toString().toLowerCase();
   }
   
   private static boolean isLetter(char in) {
      if ((in >= 'A' && in <= 'Z') || (in >= 'a' && in <= 'z')) {
         return true;
      }
      return false;
   }
   
   private static String reverseString(String in) {
      StringBuilder reversed = new StringBuilder(in.length());
      
      for (int i = in.length() - 1; i >= 0; i--) {
         reversed.append(in.charAt(i));
      }
      
      return reversed.toString();
   }
}