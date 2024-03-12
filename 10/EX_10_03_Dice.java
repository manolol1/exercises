/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.12.2023
* HUE:            10
* Bsp:            03
* Beschreibung:   Wuerfeln, bis zweimal hintereinander
                  dieselbe Zahl gewuerfelt wurde.
*********************************************/

public class EX_10_03_Dice {
   public static void main(String[] args){
      int ub = 6;
      int lb = 1;
      int dice = 0;
      int rollCtr = 0;
      int previousNum = 0;
      boolean twiceInRow = false;
      
      while (!twiceInRow) {
         dice = (int) (Math.random() * (ub - lb + 1) + lb);
         rollCtr++;
         System.out.print(dice + " ");
         if (dice == previousNum) twiceInRow = true;
         previousNum = dice;
      }
      
      System.out.println("\nEs wurde " + rollCtr + "x gewuerfelt.");
   }
}