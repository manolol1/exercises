// Hausübung 12
// Aufgaben 11 bis 17
// Mario Ebenhofer

public class EX_11_12_13_14_15_16_17 {

   static void printArray(int[] array) {
      System.out.print(array[0]);
      for (int i = 1; i < array.length; i++) {
         System.out.print(", " + array[i]);
      }
   }

   static int reverseInt(int num) {
      String reversed = "";
      while (num > 0) {
         reversed += num % 10;
         num /= 10;
      }
      
      return Integer.parseInt(reversed);
   }
   
   public static void main(String[] args) {
      /* Aufgabe 11 */
      {
         int tempFactorial;
         
         for (int i = 1; i <= 15; i++) {
            tempFactorial = 1;
            
            System.out.print(i + "! = 1");
            
            for (int j = 2; j <= i; j++) {
               tempFactorial *= j;
               System.out.print("*" + j);
            }
            
            System.out.println(" = " + tempFactorial);
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 12 */
      {
         int one;
         int ten;
         
         for (int i = 10; i <= 99; i++) {
            one = i % 10;
            ten = i / 10;
            System.out.println("Die Ziffernsumme von " + i + " = " + (one + ten));
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 13 */
      {
         final int LB = 100;
         final int UB = 999;
         final int MAX_NUMBERS_PER_LINE = 8;
         int currNumbersInLine = 0;
         
         for (int i = LB; i <= UB; i++) {
            if (i == reverseInt(i)) {
               if (currNumbersInLine != 0) System.out.print("\t");
               System.out.print(i);
               currNumbersInLine++;
               
               if (currNumbersInLine == MAX_NUMBERS_PER_LINE) {
                  System.out.println();
                  currNumbersInLine = 0;
               }
            }
         }
      }
         
      System.out.println("\n\n");
         
         /* Aufgabe 14 */
      {
         final int SIZE = 6; 
         
         // top
         for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < i; j++) {
               System.out.print(" ");
            }
            
            for (int j = 0; j < 2 * (SIZE - i) - 1; j++) {
               System.out.print("*");
            }
         
            System.out.println();
         }
      
         // bottom
         for (int i = SIZE - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
               System.out.print(" ");
            }
            
            for (int j = 0; j < 2 * (SIZE - i) - 1; j++) {
               System.out.print("*");
            }
         
            System.out.println();
         }
      }
      
      System.out.println("\n\n");
      
      /* Aufgabe 15 */
      {
         int[] numbers = {43, 544, 76, 653, 21};
         int max = Integer.MIN_VALUE;
         
         System.out.print("Das Maximum der Zahlen ");
         
         for (int i = 0; i < numbers.length; i++) {
            // print numbers
            if (i == 0) {
               System.out.print(numbers[i]);
            } else if (i == numbers.length - 1) {
               System.out.print(" und " + numbers[i] + " = ");
            } else {
               System.out.print(", " + numbers[i]);
            }
            
            if (numbers[i] > max) max = numbers[i];
         }
         System.out.println(max);
      }
      
      System.out.println("\n\n");
      
      /* Aufgaben 16 und 17 */
      {
         int[] numbers = {24, 11, 17, 13};
         int temp;
         int index = numbers.length - 1;
         
         System.out.print("Unsortiert: ");
         printArray(numbers);
         
         while (index > 0) {
            for (int i = 0; i < index; i++) {
               // compare numbers and swap them if the "left" 
               // number is larger than the "right" number
               if (numbers[i] > numbers[i + 1]) {
                  temp = numbers[i];
                  numbers[i] = numbers[i + 1];
                  numbers[i + 1] = temp;
               }
            }
            index--;
         }
         System.out.print("\nSortiert: ");
         printArray(numbers);
      }
   }
}