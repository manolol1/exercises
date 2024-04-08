public class EX_String {
   public static void main(String[] args) {
      String str = "Hallo   Max, * wie geht es dir?";
      
      str = removeNonAlphabeticalCharacters(str);
      
      System.out.println(str);
      System.out.println(swapCase(str));
      
      char ch = 'A';
      System.out.println(ch + ": " + getUnicode(ch));
      
      char ch1 = '\u00A1';
      System.out.println(ch1);
   }
   
   private static String removeNonAlphabeticalCharacters(String in) {
      StringBuilder result = new StringBuilder(in.length());
      
      for (int i = 0; i < in.length(); i++) {
         if (isLetter(in.charAt(i))) {
            result.append(in.charAt(i));
         }
      }
      
      return result.toString();
   }
   
   private static String swapCase(String in) {
      StringBuilder result = new StringBuilder(in.length());
      
      for (int i = 0; i < in.length(); i++) {
         if (Character.isUpperCase(in.charAt(i))) {
            result.append(Character.toLowerCase(in.charAt(i)));
         } else {
            result.append(Character.toUpperCase(in.charAt(i)));
         }
      }
      
      return result.toString();
   }
   
   private static boolean isLetter(char in) {
      if (in >= 'A' && in <= 'Z' || in >= 'a' && in <= 'z') {
         return true;
      }
      
      // special cases
      switch (in) {
         case 'Ä':
         case 'Ö':
         case 'Ü':
            return true;
      }
      
      return false;
   }
   
   private static int getUnicode(char in) {
      return (int) in;
   }
}