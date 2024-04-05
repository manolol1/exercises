/********************************************
* Name:           Mario Ebenhofer
* Datum:          03.04. 2024
* HUE:            21
* Bsp:            02
* Beschreibung:   Normale Sprache mit B-Sprache "verschluesseln"
*********************************************/

import java.util.Scanner;

public class EX_21_02_B_Code {
   static final char DEFAULT_REPLACEMENT = 'B';
   
   static char replacement = DEFAULT_REPLACEMENT; // can be changed using arg0 line arg1s
   
   public static void main(String[] args){
      final String INVALID_ARGS = "Invalid arguments. Use --help for a list of all available commands.";
      
      if (args.length == 0) {
         cmdDefault();
         System.exit(0);
      }
   
      String arg0 = "default";
      String arg1 = null;
      String arg2 = null;
      
      // set arguments to their corresponding variable
      for (String arg : args) {
         arg = arg.trim();
         if (arg.equals("--help") || arg.equals("-h") ||
         arg.equals("--encrypt") || arg.equals("-e") ||
         arg.equals("--decrypt") || arg.equals("-d")) {
            arg0 = arg;
         }
         else if (arg.startsWith("--replacement=")) {
            arg2 = arg;
         } 
         else if (arg.charAt(0) == '-') {
            System.out.println(INVALID_ARGS);
            System.exit(0);
         }else {
            arg1 = arg;
         }
      }
   
      // help command
      if (arg0.equals("--help") || arg0.equals("-h")) {
         cmdHelp();
      }
   
      // custom replacement
      if (arg2 != null) {
         if (arg2.length() > 15) {
            System.out.println("WARNING: Replacement can only be a single character. Additional characters are ignored.");
         }
         replacement = arg2.toUpperCase().charAt(14);
         System.out.println("Using custom replacement character: '" + replacement + "'\n");
      }
   
      // mode
      if (arg0.equals("default")) {
         cmdDefault();
      } else if (arg0.equals("--encrypt") || arg0.equals("-e")) {
         if (arg1 != null) {
            cmdEncrypt(arg1);
         } else {
            cmdEncrypt();
         }
      } else if (arg0.equals("--decrypt") || arg0.equals("-d")) {
         if (arg1 != null) {
            cmdDecrypt(arg1);
         } else {
            cmdDecrypt();
         }
      } else {
         System.out.println(INVALID_ARGS);
      }
   }
   
   private static void cmdHelp() {
      System.out.println("Available arguments:\n");
      
      System.out.println("--help or -h               \t Displays this information");
      System.out.println("--encrypt or -e            \t Starts encryption mode (enter String to encrypt later)");
      System.out.println("--encrypt or -e <String>   \t Encrypts a String");
      System.out.println("--decrypt or -d            \t Starts decryption mode (enter String to decrypt later)");
      System.out.println("--decrypt or -d <String>   \t Decrypts a String");
      System.out.println("--replacement=<character>  \t Provide a custom replacement character");
      System.exit(0);
   }
   
   private static void cmdDefault() {
      System.out.println("[Default Mode - Encryption] \n");
      final String INPUT = stringInput();
      String encrypted = encrypt(INPUT);
      String decrypted = decrypt(encrypted);
      System.out.println("Encrypted: " + encrypted);
      System.out.println("Decrypted: " + decrypted);
   }
   
   private static void cmdEncrypt() {
      System.out.println("[Encryption Mode]\n");
      final String INPUT = stringInput();
      String encrypted = encrypt(INPUT);
      System.out.println("Encrypted: " + encrypted);
   }
   
   private static void cmdEncrypt(String INPUT) {
      System.out.println("[Encryption Mode]\n");
      System.out.println("Encrypting String: " + INPUT);
      String encrypted = encrypt(INPUT);
      System.out.println("Encrypted: " + encrypted);
   }
   
   private static void cmdDecrypt() {
      System.out.println("[Decryption Mode]\n");
      final String INPUT = stringInput();
      String decrypted = decrypt(INPUT);
      System.out.println("Decrypted: " + decrypted);
   }
   
   private static void cmdDecrypt(String INPUT) {
      System.out.println("[Decryption Mode]\n");
      System.out.println("Decrypting String: " + INPUT);
      String decrypted = decrypt(INPUT);
      System.out.println("Decrypted: " + decrypted);
   }
   
   private static String stringInput() {
      Scanner s = new Scanner(System.in);
      System.out.print("Input: ");
      return s.nextLine();
   }
   
   private static String encrypt(String in) {
      StringBuilder result = new StringBuilder(in.length() * 3);
      
      for (char ch : in.toCharArray()) {
         result.append(ch); // always add character once
         
         if (isVocal(ch)) {
            // append correct replacement, depending on case
            if (Character.isUpperCase(ch)) {
               result.append(replacement);
            } else {
               result.append(Character.toLowerCase(replacement));
            }
            
            result.append(ch);
         }
      }
      
      return result.toString();
   }
   
   private static String decrypt(String in) {
      StringBuilder result = new StringBuilder(in.length());
      
      char firstVocal;
      for (int i = 0; i < in.length(); ) {
         // check for encrypted sequence (vocal - replacement - same vocal)
         if (i < in.length() -2 && Character.toUpperCase(in.charAt(i + 1)) == replacement && in.charAt(i) == in.charAt(i + 2)) {
            result.append(in.charAt(i));
            i += 3; // skip replacement and repeated char and move on
         } else {
            result.append(in.charAt(i));
            i++; // move on to next char
         }
      }
      
      return result.toString();
   }
   
   private static boolean isVocal(char ch) {
      final char[] VOCALS = {'A', 'I', 'U', 'E', 'O'};
      
      for (int i = 0; i < VOCALS.length; i++) {
         if (Character.toUpperCase(ch) == VOCALS[i]) {
            return true;
         }
      }
      
      return false;
   }
}