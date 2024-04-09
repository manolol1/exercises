/********************************************
* Name:           Mario Ebenhofer
* Datum:          03.04. 2024
* HUE:            21
* Bsp:            03
* Beschreibung:   Haufigkeit von Buchstaben in String auswerten.
*********************************************/

import java.util.Scanner;
import java.io.*;

public class EX_21_03_TextAnalysis {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int[] count = new int[26]; // A = 0; B = 1; ...
      
      final String INPUT;
      
      // read input (either from file or interactively)
      if (args.length == 1) {
         INPUT = readFile(args[0]).toUpperCase();
      } else {
         System.out.print("Eingabe: ");
         INPUT = s.nextLine().toUpperCase();
      }
      
      System.out.println();
      
      // count letters
      for (int i = 0; i < INPUT.length(); i++) {
         for (int j = 0; j < 26; j++) {
            if (INPUT.charAt(i) == 65 + j) {
               count[j]++;
            }
         }
      }
      
      // print statistic
      System.out.println("Statistik:");
      for (int i = 0; i < count.length; i++) {
         System.out.print((char) (65 + i) + ":");
         System.out.printf("%6d x", count[i]);
         System.out.println("\t\t" + graphicalNum(count[i]));
      }
   }
   
   private static String graphicalNum(int n) {
      StringBuilder result = new StringBuilder(n + n/5);
      
      for (int i = 0; i < n; i++) {
         if (i % 5 == 0 && i != 0) {
            result.append(" ");
         }
         result.append("|");
      }
      
      return result.toString();
   }
   
   private static String readFile(String filePath) {
      String result = "";
      
      try {
         File file = new File(filePath);
         Scanner s = new Scanner(file);
         
         while (s.hasNextLine()) {
            result += s.nextLine();
         }
         
         s.close();
         System.out.println("Successfully read file " + filePath);
      } catch (FileNotFoundException e) {
         System.out.println("Could not read file.");
         System.exit(1);
      }
      
      return result;
   }
}