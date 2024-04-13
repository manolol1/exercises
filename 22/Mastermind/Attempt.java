/**************
*  EX: 22_04  *
**************/

public class Attempt {
   private int[] digits;
   private int red, white;
   
   public Attempt(int[] digits, int red, int white) {
      this.digits = digits;
      this.red = red;
      this.white = white;
   }
   
   public void print() {
      for (int i = 0; i < digits.length; i++) {
         System.out.print(digits[i] + "\t");
      }
      for (int i = 0; i < red; i++) {
         System.out.print('r');
      }
      for (int i = 0; i < white; i++) {
         System.out.print('w');
      }
      System.out.println();
   }
}