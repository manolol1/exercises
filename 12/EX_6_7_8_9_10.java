// Hausübung 12
// Aufgaben 6 bis 10
// Mario Ebenhofer

public class EX_6_7_8_9_10 {
   
   // Method that returns the factorial of a number
   static int factorial(int num) {
      int factorial = 1;
         
      for (int i = 1; i <= num; i++) {
         factorial *= i;
      }
         
      return factorial;
   }
   
   // Method that returns a random number between lb and ub
   static int getRandom(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
      
      
   public static void main(String[] args) {
      /* Aufgabe 6 */
      {
         final int AMOUNT_OF_NUMBERS = 10;
         final int LB = 1;
         final int UB = 100;
         
         int[] numbers = new int[AMOUNT_OF_NUMBERS];
         int min = Integer.MAX_VALUE;
         int min2 = Integer.MAX_VALUE;
         
         System.out.print("Zufallszahlen:\t\t\t");
         
         for (int i = 0; i < numbers.length; i++) {
            numbers[i] = getRandom(LB, UB);
            
            if (i > 0) System.out.print(" ");
            System.out.print(numbers[i]);
            
            if (numbers[i] < min) {
               min = numbers[i];
            } else if (numbers [i] < min2 && numbers[i] != min) {
               min2 = numbers[i];
            }
         }
         
         System.out.println("\nKleinste Zahl:\t\t\t" + min);
         System.out.println("Zweitkleinste Zahl:\t" + min2);
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 7 */
      {  
         int one;
         int ten;
         int hundred;
         int factorialSum;
         
         for (int i = 100; i <= 999; i++) {
            one = i % 10;
            ten = i / 10 % 10;
            hundred = i / 100;
            
            factorialSum = factorial(one) + factorial(ten) + factorial(hundred);
            
            if (i == factorialSum) System.out.println(i);
         }  
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 8 */
      {
         final int MAX_NUMBERS_PER_LINE = 10;
         int currNumbersInLine = 0;
         
         int one;
         int ten;
         int hundred;
         int sum;
         
         for (int i = 100; i <= 999; i++) {
            one = i % 10;
            ten = i / 10 % 10;
            hundred = i / 100;
            
            sum = one + ten + hundred;
            
            if (i % sum == 0) {
               if (currNumbersInLine > 0) System.out.print(" ");
               System.out.print(i);
               currNumbersInLine++;
               
               if (currNumbersInLine >= MAX_NUMBERS_PER_LINE) {
                  System.out.println();
                  
                  currNumbersInLine = 0;
               }
            }
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 9 */
      {
         int one;
         int ten;
         int hundred;
         int cubicSum;
         
         for (int i = 100; i <= 999; i++) {
            one = i % 10;
            ten = i / 10 % 10;
            hundred = i / 100;
            
            cubicSum = (int) (Math.pow(one, 3) + Math.pow(ten, 3) + Math.pow(hundred, 3));
            
            if (i == cubicSum) System.out.println(i);
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 10 */
      {
         final int MAX_NUMBERS_PER_LINE = 6;
         int currNumbersInLine = 0;
         int quotient = 4;
         
         int one;
         int ten;
         int hundred;
         int sum;
         
         for (int i = 10; i <= 99; i++) {
            one = i % 10;
            ten = i / 10 % 10;
            
            sum = one + ten;
            
            if (i > (sum * quotient)) {
               if (currNumbersInLine > 0) System.out.print(" ");
               System.out.print(i);
               currNumbersInLine++;
               
               if (currNumbersInLine >= MAX_NUMBERS_PER_LINE) {
                  System.out.println();
                  
                  currNumbersInLine = 0;
               }
            }
         }
      }
   }
}