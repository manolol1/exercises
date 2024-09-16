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
      System.out.println("New waiting room, unsorted: " + arrayToString(seats, ", "));
      
      sortSeats(seats);
      System.out.println("New waiting room, sorted: " + arrayToString(seats, ", "));
      
      System.out.println("Treating a patient...");
      treatPatient(seats);
      System.out.println("Waiting room after treating a patient: " + arrayToString(seats, ", "));
      
      System.out.println("New patient enters...");
      addPatient(seats, PRIORITY_MIN, PRIORITY_MAX);
      System.out.println("Waiting room after adding a patient: " + arrayToString(seats, ", "));
   }
   
   /** Add new patient to array, if it itsn't already "full" */
   public static void addPatient(int[] ar, int min, int max) {
      sortSeats(ar); // make sure that array is sorted
      
      if (ar[ar.length - 1] != 0) {
         System.out.println("Waiting room is already full. :(");
      } else {
         ar[ar.length - 1] = random(min, max);
         sortSeats(ar);
      }
   }
   
   /** Set first element in an array to 0 and sort the array again */
   public static void treatPatient(int[] ar) {
      if (ar[0] == 0) {
         System.out.println("There is no patient to treat!");
      } else {
         ar[0] = 0;
         sortSeats(ar);
      }
   }
   
   /** Sort all seats and shift empty seats (0) to the right */
   public static void sortSeats(int[] ar) {
      sort(ar);
      
      for (int i = 0; i < ar.length && ar[0] == 0; i++)  {
         shiftLeft(ar);
      }
   }
   
   /** Shift an Array to the left, where the first element becomes the last */
   public static void shiftLeft(int[]ar) {
      int temp = ar[0];
      for (int i = 1; i < ar.length; i++) {
         ar[i - 1] = ar[i];
      }
      ar[ar.length - 1] = temp;
   }
   
   /** Sort an Array in ascending order using the SelectionSort algorithm */
   public static void sort(int[] ar) {
      int minIndex, temp;
      
      for (int i = 0; i < ar.length - 1; i++) {
         minIndex = i;
         
         // find minIndex
         for (int j = i + 1; j < ar.length; j++) {
            if (ar[j] < ar[minIndex]) {
               minIndex = j;
            }
         }
         
         // swap
         temp = ar[i];
         ar[i] = ar[minIndex];
         ar[minIndex] = temp;
      }
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