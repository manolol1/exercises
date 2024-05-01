// 3. Test
// Aufgabe d
// Mario

public class Test_d {
   public static void main(String[] args) {
      int dices = 10;
      int lb = 1, ub = 6; // dice
      
      boolean done = false;
      boolean[] pass = new boolean[ub];
      int rollCtr = 0;
      
      while (!done) {
         rollCtr++;
         int[] rolls = new int[dices];
         
         // roll all dices
         for (int i = 0; i < dices; i++) {
            rolls[i] = random(lb, ub);
         }
         
         // print current roll
         System.out.print("Wurf " + rollCtr + ": ");
         printArray(rolls);
         
         // check for passes
         for (int i = lb; i <= ub; i++) { // check for every dice number
            boolean canBePass = true;
            
            // check if all rolls == current dice number
            for (int roll : rolls) {
               if (i != roll) {
                  canBePass = false;
                  break;
               }
            }
            
            if (canBePass) {
               System.out.print(" (Pasch)");
               pass[i - 1] = true;
            }
         }
         
         // check if done
         done = true;
         for (boolean p : pass) {
            if (!p) {
               done = false;
               break;
            }
         }
         
         System.out.println();
      }
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
   
   private static void printArray(int[] ar) {
      System.out.print(ar[0]);
      for (int i = 1; i < ar.length; i++) {
         System.out.print(" und " + ar[i]);
      }
   }
}