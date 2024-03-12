import java.util.Scanner;

public class Test {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int lb;
      int ub;
      int steps;
      
      long start;
      long finish;
      long timeElapsed;
      
      
      System.out.print("LowerBound: ");
      lb = s.nextInt();
      System.out.print("UpperBound: ");
      ub = s.nextInt();
      System.out.print("Steps: ");
      steps = s.nextInt();
      
      if (ub < lb) {
         System.out.println("UpperBound can't be smaller than LowerBound!");
         System.exit(0);
      }
      
      start = System.currentTimeMillis();
      
      for (int i = lb; i <= ub; i += steps) {
         System.out.println(i);
      }
      
      finish = System.currentTimeMillis();
      timeElapsed = finish - start;
      
      System.out.println("Execution took " + timeElapsed + " milliseconds.");
      
   }
}