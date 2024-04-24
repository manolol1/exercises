// 3. Test
// Aufgabe a
// Mario

public class Test_a {
   public static void main(String[] args) {
      int lb = 1, ub = 20;
      int length = 10;
      
      int[] ar = new int[10];
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      boolean isUnique = true;
      
      // fill with random numbers
      for (int i = 0; i < length; i++) {
         int random = random(lb, ub);
         
         if (i % 2 == 0) {
            while (random % 2 != 0) {
               random = random(lb, ub);
            }
         } else {
            while (random % 2 != 1) {
               random = random(lb, ub);
            }
         }
         
         ar[i] = random;
      }
      
      for (int i = 0; i < length; i++) {
         // find max1 and max2
         if (ar[i] >= max1) {
            max1 = ar[i];
         } else if (ar[i] >= max2) {
            max2 = ar[i];
         }
         
         // check if array is unique
         if (isUnique) {
            for (int j = i + 1; j < length; j++) {
               if (ar[i] == ar[j]) {
                  isUnique = false;
                  break;
               }
            }
         }
      }
      
      // Output
      System.out.print("Array:\t\t\t\t\t");
      printArray(ar);
      System.out.println("\n\nGroesste Zahl:\t\t\t" + max1);
      System.out.println("Zweitgroesste Zahl:\t" + max2);
      System.out.println("\nVerschiedene Zahlen:\t" + (isUnique ? "Ja" : "Nein"));
   }
   
   private static void printArray(int[] ar) {
      System.out.print(ar[0]);
      for (int i = 1; i < ar.length; i++) {
         System.out.print(" " + ar[i]);
      }
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
}