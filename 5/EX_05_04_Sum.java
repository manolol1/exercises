/*************************************************
* Name:           Mario Ebenhofer
* Datum:          18.10.2023
* HUE:            05
* Bsp:            04
* Beschreibung:   Ziffernsumme aller zweififfrigen Zahlen
**************************************************/

public class EX_05_04_Sum{
   public static void main(String[] args){
      int ctr = 10;
      while(ctr < 100){
         System.out.println("Die Ziffernsumme von " + ctr + " betraegt " + (ctr%10 + ctr/10));
         ctr++;
      }
   }
}