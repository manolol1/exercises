// Hausübung 12
// Aufgaben 22 bis 25
// Mario Ebenhofer

public class EX_22_23_24_25 {

   static int sumOfDividers(int num) {
      int sum = 0;
      
      for (int i = 1; i <= num / 2; i++) {
         if (num % i == 0) {
            sum += i;
         }
      }
      
      return sum;
   }

   public static void main(String[] args) {
      /* Aufgabe 22 */
      {
         int num = 22;
         
         System.out.print(num);
         
         while (num != 1) {
            if (num % 2 == 0) {
               num /= 2;
            } else {
               num = num * 3 + 1;
            }
            System.out.print(", " + num);
         }
         System.out.print(".");
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 23 */
      {
         final int LB = 10;
         final int UB = 30;
         
         for (int i = LB; i <= UB; i++) {
            for (int j = i + 1; j <= UB; j++) {
               if (sumOfDividers(i) == sumOfDividers(j)) {
                  System.out.println(i + " und " + j);
               }
            }
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 24 */
      {
         final int LB = 1;
         final int UB = 1000;
         
         int square;
         String squareString;
         int squareLength;
         int middle;
         String rightString;
         String leftString;
         int right;
         int left;
         
         for (int i = LB; i <= UB; i++) {
            square = i * i;
            
            squareString = String.valueOf(square);
            squareLength = squareString.length();
            
            // Split squareString into two parts
            middle = squareLength / 2;
            leftString = squareString.substring(0, middle);
            rightString = squareString.substring(middle);
            
            // Convert Strings to Integers.
            left = leftString.isEmpty() ? 0 : Integer.valueOf(leftString);
            right = rightString.isEmpty() ? 0 : Integer.valueOf(rightString);
            
            if (left + right == i) {
               System.out.println(i + "^2 = " + squareString + ", " + leftString + " + " + rightString + " = " + i);
            }
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 25 */
      {
         final int LB = 10;
         final int UB = 1000;
         
         int sum = 0;
         int length;
         int temp;
         int[] digits;
         
         for (int i = LB; i <= UB; i++) {
            sum = 0;
            length = String.valueOf(i).length();
            digits = new int[length];
            
            temp = i;
            
            for (int j = 0; j < length; j++) {
               digits[j] = temp % 10;
               temp /= 10;
               
               sum += Math.pow(digits[j], length);
            }
            
            if (sum == i) {
               System.out.print(sum + " = " + digits[0] + "^" + length);
               
               for (int j = 1; j < length; j++) {
                  System.out.print(" + " + digits[j] + "^" + length);
               }
               System.out.println();
            }
         }
      }
   }
}