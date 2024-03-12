/***************************************************************************
* Name:           Mario Ebenhofer
* Datum:          12.03. 2024
* HUE:            19
* Bsp:            01
* Beschreibung:   Sortieren mit BubbleSort, SelectionSort und InsertionSort
***************************************************************************/

public class EX_19_01_Sort {
   public static void main(String[] args){
      final int LENGTH = 20, LB = 1, UB = 100;
      int[] ar1 = randomArray(LENGTH, LB, UB);
      int[] ar2 = randomArray(LENGTH, LB, UB);
      int[] ar3 = randomArray(LENGTH, LB, UB);
      
      System.out.println("Unsortiert: " + arrayAsString(ar1));
      bubbleSort(ar1);
      System.out.println("BubbleSort: " + arrayAsString(ar1) + "\n");
      
      System.out.println("Unsortiert: " + arrayAsString(ar2));
      selectionSort(ar2);
      System.out.println("SelectionSort: " + arrayAsString(ar2) + "\n");
      
      System.out.println("Unsortiert: " + arrayAsString(ar3));
      insertionSort(ar3);
      System.out.println("InsertionSort: " + arrayAsString(ar3));
   }
   
   private static void bubbleSort(int[] ar) {
      boolean done = false;
      int temp;
      while (!done) {
         done = true;
         for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
               done = false;
               temp = ar[i + 1];
               ar[i + 1] = ar[i];
               ar[i] = temp;
            }
         }
      }
   }
   
   private static void selectionSort(int[] ar) {
      int minIndex, temp;
      for (int i = 0; i < ar.length - 1; i++) {
         minIndex = i;
         for (int j = i + 1; j < ar.length; j++) {
            if (ar[j] < ar[minIndex]) {
               minIndex = j;
            }
         }
         if (minIndex != i) {
            temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
         }
      }
   }
   
   private static void insertionSort(int[] ar) {
      for (int i = 1; i < ar.length; i++) {
         int currNum = ar[i];
         int j = i - 1;
         while (j >= 0 && ar[j] > currNum) {
            ar[j + 1] = ar[j]; // shift right
            j--;
         }
         ar[j + 1] = currNum;
      }
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
      
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1) + lb);
      }
      
      return ar;
   }
   
   private static String arrayAsString(int[] ar) {
      String str = "" + ar[0];
      
      for (int i = 1; i < ar.length; i++) {
         str += (", " + ar[i]);
      }
      
      return str;
   }
}