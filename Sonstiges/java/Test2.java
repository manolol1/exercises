import java.util.Scanner;

public class Test2 {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int a, b, c, d;
      int max = 0;
      int secondMax = -2000000000;
      
      // Input
      System.out.print("Zahl 1: ");
      a = s.nextInt();
      System.out.print("Zahl 2: ");
      b = s.nextInt();
      System.out.print("Zahl 3: ");
      c = s.nextInt();
      System.out.print("Zahl 4: ");
      d = s.nextInt();
      
      max = a;
      
      // Get largest and 2nd largest number
      if (b > max) {
         secondMax = max;
         max = b;
      } else if (b > secondMax) {
         secondMax = b;
      }
   
      if (c > max) {
         secondMax = max;
         max = c;
      } else if (c > secondMax) {
         secondMax = c;
      }
   
      if (d > max) {
         secondMax = max;
         max = d;
      } else if (d > secondMax) {
         secondMax = d;
      }
      
      System.out.println("\nMax: " + max);
      System.out.println("\nSecondMax: " + secondMax);
   
      
   }
}