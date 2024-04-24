// 3. Test
// Aufgabe c
// Mario

import java.util.Scanner;

public class Test_c {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int lb = 5, ub = 30; // input bounds
      
      int n = lb - 1;
      boolean inputDone = false;
      String password = "";
      int ctr = 1;
      
      while (!inputDone) {
         System.out.printf("Passwortlaenge (zwischen %d und %d): ", lb, ub);
         n = s.nextInt();
         
         if (n >= lb && n <= ub) {
            inputDone = true;
         } else {
            System.out.println("Ungueltige Eingabe. Bitte erneut versuchen!\n");
         }
      }
      
      // generate password
      while (password.length() < n) {
         switch (ctr) {
            case 1: password += (char) random(65, 90); break;
            case 2: password += (char) random(97, 122); break;
            case 3: password += random(0, 9); ctr = 0;
         }
         ctr++;
      }
      
      System.out.println("Passwort: " + password);
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
}