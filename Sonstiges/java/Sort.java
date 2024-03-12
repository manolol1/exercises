public class Sort{
   public static void main(String[] args) {
      final int LB = 1, UB = 1000000;
      final int LENGTH = 100000;
      final int PRINT_LIMIT = 50;
      
      int[] numbers = new int[LENGTH];
   
      boolean sortingDone = false;
      int temp;
   
      for (int i = 0; i < LENGTH; i++) {
         numbers[i] = (int) (Math.random() * (UB - LB + 1) + LB); 
      }
      
      System.out.printf("Unsorted: ");
      for (int i = 0; i < PRINT_LIMIT; i++) {
         System.out.printf("%d ", numbers[i]);
      }
      
      System.out.printf("\n");
            
      while (!sortingDone) {
         sortingDone = true;
         for (int i = 0; i < LENGTH - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
               sortingDone = false;
               temp = numbers[i + 1];
               numbers[i + 1] = numbers[i];
               numbers[i] = temp;
            }
         }
      }
   
      System.out.printf("Sorted: ");
      for (int i = 0; i < PRINT_LIMIT; i++) {
         System.out.printf("%d ", numbers[i]);
      }
      
      System.out.printf("\n");
   }
}