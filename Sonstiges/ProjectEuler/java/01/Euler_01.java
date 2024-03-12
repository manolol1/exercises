// projecteuler.net
// Problem 1
// Multiples of 3 or 5

public class Euler_01 {
   public static void main(String[] args) {
       int ctr = 3;
       int sum = 0;
       
       while (ctr < 1000) {
         if (ctr % 3 == 0 || ctr % 5 == 0) {
            sum += ctr;
         }
         ctr++;
       }
       
       System.out.println(sum);
   }
}