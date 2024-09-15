/********************************************
* Name:          Mario Ebenhofer
* Date:          12.01. 2024
* HUE:           00
* EX:            04
* Description:   Doctor's waiting room
*********************************************/

public class EX_00_04_Anwendungsbeispiel {
   public static void main(String[] args) {
      // Constants
      final int SEAT_OCCUPANCY_PERCENT = 60; // 0 - 100
      final int SEAT_COUNT = 25; // > 0
      final int PRIORITY_MIN = 1, PRIORITY_MAX = 10;
      
      // Check constants
      sanityCheck(SEAT_OCCUPANCY_PERCENT, 0, 100, "SEAT_OCCUPANCY_PERCENT");
      sanityCheck(SEAT_COUNT, 0, Integer.MAX_VALUE, "SEAT_COUNT");
      
      int[] seats = new int[SEAT_COUNT];
      
      fill(seats, SEAT_OCCUPANCY_PERCENT, PRIORITY_MIN, PRIORITY_MAX);
      printArray(seats);
   }
   
   /** Fill an int array with random values */
   public static void fill(int[] ar, int probability, int lb, int ub) {
      for (int i = 0; i < ar.length; i++) {
         // determine if seat is occupied
         if (random(1, 100) <= probability) {
            ar[i] = random(lb, ub);
         } else {
            ar[i] = 0;
         }
      }
   }
   
   /** Print an int array with ", " as a default delimiter */
   public static void printArray(int[] ar) {
      System.out.println(arrayToString(ar, ", "));
   }
   
   /** Print an int array */
   public static void printArray(int[] ar, String delimiter) {
      System.out.println(arrayToString(ar, delimiter));
   }
   
   /** Efficiently convert an int array to a String with a delimiter between each element */
   public static String arrayToString(int[] ar, String delimiter) {
      StringBuilder sb = new StringBuilder(ar.length + ar.length * delimiter.length());
      
      sb.append(ar[0]);
      
      for (int i = 1; i < ar.length; i++) {
         sb.append(delimiter).append(ar[i]);
      }
      
      return sb.toString();
   }
   
   /** Check if a variable makes sense, end the program if not */
   public static void sanityCheck(int val, int min, int max, String variableName) {
      if (val < min || val > max) {
         System.out.printf("[ERROR] Variable \"%s\" must be between %d and %d!\n", variableName, min, max);
         System.out.println("Program execution stopped.");
         System.exit(1);
      }
   }
   
   /** Generate a random number between lower and upper */
   public static int random(int lower, int upper) {
      return (int) (Math.random() * (upper - lower + 1) + lower);
   }
}