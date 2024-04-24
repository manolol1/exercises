// 3. Test
// Aufgabe b
// Mario

public class Test_b {
   public static void main(String[] args) {
      int length = 20;
      int lb = 65, ub = 90; // for character generation
      
      char[] ar = new char[length];
      
      for (int i = 0; i < length; i++) {
         ar[i] = (char) (Math.random() * (ub - lb + 1) + lb);
      }
      
      System.out.print("Ausgabe nach dem fuellen:\t");
      printArray(ar);
      
      // SelectionSort
      for (int i = 0; i < length; i++) {
         int min = i;
         
         for (int j = i + 1; j < length; j++) {
            if (ar[j] < ar[min]) {
               min = j;
            }
         }
         
         // swap
         char temp = ar[i];
         ar[i] = ar[min];
         ar[min] = temp;
      }
      
      System.out.print("\n\nAusgabe nach dem fuellen:\t");
      printArray(ar);
   }
   
   private static void printArray(char[] ar) {
      System.out.print(ar[0]);
      for (int i = 1; i < ar.length; i++) {
         System.out.print(" " + ar[i]);
      }
   }
}