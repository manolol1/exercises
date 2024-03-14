public class SortingTime {
   public static void main(String[] args) {
      int lb = 1;
      int ub = 2_000_000_000;
      int length;
      
      length = 20_000;
      bubbleSortTime(lb, ub, length);
      
      length = 100_000;
      selectionSortTime(lb, ub, length);
   }
   
   private static void bubbleSortTime(int lb, int ub, int length) {
      int[] ar = randomArray(length, lb, ub);
      
      long start, finish, time;
      
      start = System.currentTimeMillis();
      
      bubbleSort(ar);
      
      finish = System.currentTimeMillis();
      time = finish - start;
      
      System.out.println("[BubbleSort]");
      System.out.println("Array Length: " + length);
      System.out.print("Time: " + time + "ms");
      System.out.println(" (" + time / 1000 + "s " + time % 1000 + "ms)\n");
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
   
   private static void selectionSortTime(int lb, int ub, int length) {
      int[] ar = randomArray(length, lb, ub);
      
      long start, finish, time;
      
      start = System.currentTimeMillis();
      
      selectionSort(ar);
            
      finish = System.currentTimeMillis();
      time = finish - start;
      
      System.out.println("[SelectionSort]");
      System.out.println("Array Length: " + length);
      System.out.print("Time: " + time + "ms");
      System.out.println(" (" + time / 1000 + "s " + time % 1000 + "ms)\n");
   }
   
   private static void selectionSort(int[] ar) {
   
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
      
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1) + lb);
      }
      
      return ar;
   }
}