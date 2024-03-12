/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          15.11.2023
* HUE:            08
* Bsp:            05
* Beschreibung:   Alle dreistelligen Zahlen ausgeben, die aus
*                 verschiedenen Ziffern bestehen und durch
*                 3 teilbar sind
************************************************************/

public class Ex_08_05_DiffDigit {
   public static void main(String[] args) {
      int lb = 100;
      int ub = 999;
      int divider = 3;
      int ctr = lb;
      int tempUnit;
      int tempDecade;
      int tempHundreds;
      
      while (ctr <= ub) {
         tempUnit = ctr % 10;
         tempDecade = ctr / 10 % 10;
         tempHundreds = ctr / 100;
         
         if (tempUnit != tempDecade && tempDecade != tempHundreds && tempUnit != tempHundreds && ctr % divider == 0) {
            System.out.println(ctr);
         }
         ctr++;
      }
   }
}