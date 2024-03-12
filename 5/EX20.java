public class EX20 {
   public static void main(String[] args) {
      int numOfTwins = 30;
      
      int twinsFound = 0;
      
      int num1 = 3;
      int num2 = 5;
      
      boolean isPrime = true;
      int divider;
      boolean nextPrimeFound = false;
      int primeCheckNum;
      
      while (twinsFound < numOfTwins) {
         if (num2 - num1 == 2) {
            System.out.println(num1 + " und " + num2);
            twinsFound++;
         }
         
         // nächste Primzahl nach num1 finden
         num1++;
         nextPrimeFound = false;
         while (!nextPrimeFound) { // while (nextPrimeFound = false)
            primeCheckNum = num1;
            
            isPrime = true;
            divider = 2;
            
            if (primeCheckNum <= 1) {
               isPrime = false;
            }
            
            while (isPrime && divider <= Math.sqrt(primeCheckNum)) {
               if (num1 % divider == 0) {
                  isPrime = false;
               }
               
               divider++;
            }
            
            if (isPrime) {
               nextPrimeFound = true;
            } else {
               num1++;
            }
         }
         
         
         // nächste Primzahl nach num1 finden
         num2++;
         nextPrimeFound = false;
         while (!nextPrimeFound) { // while (nextPrimeFound = false)
            primeCheckNum = num2;
            
            isPrime = true;
            divider = 2;
            
            if (primeCheckNum <= 1) {
               isPrime = false;
            }
            
            while (isPrime && divider <= Math.sqrt(primeCheckNum)) {
               if (primeCheckNum % divider == 0) {
                  isPrime = false;
               }
               
               divider++;
            }
            
            if (isPrime) {
               nextPrimeFound = true;
            } else {
               num2++;
            }
         }
      }
   }
}