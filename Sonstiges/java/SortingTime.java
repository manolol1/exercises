public class SortingTime {
   public static void main(String[] args) {
      int lb = 1;
      int ub = 2_000_000_000;
      int length;
      
      length = 100_000;
      bubbleSort(lb, ub, length);
   }
   
   private static void bubbleSort(int lb, int ub, int length) {
      int[] ar = randomArray(length, lb, ub);
      
      long start, finish, time;
      
      start = System.currentTimeMillis();
      
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
      
      finish = System.currentTimeMillis();
      time = finish - start;
      
      System.out.println("[BubbleSort]");
      System.out.println("Array Length: " + length);
      System.out.println("Time: " + time + "ms");
      System.out.print(" - " + time / 1000 + "s " + time % 1000 + "ms\n");
   }
   
   private static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];
      
      for (int i = 0; i < length; i++) {
         ar[i] = (int) (Math.random() * (ub - lb + 1) + lb);
      }
      
      return ar;
   }
}