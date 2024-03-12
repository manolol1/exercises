/********************************************
* Name:           Mario Ebenhofer
* Datum:          11.10.2023
* HUE:            04
* Bsp:            02
* Beschreibung:   Ziffernsumme
*                 (Zwei- bis Vierstellig)
*********************************************/

public class EX_04_02_Sum{
   public static void main(String[] args){
      // Eingabe
      int num1 = 53; // Zweistellig
      int num2 = 137; // Dreistellig
      int num3 = 4503; // Vierstellig
      
      // Zahlen für die Ausgabe speichern
      int num2s = num2; 
      int num3s = num3;
      
      // Zweistellige Zahl
      int e1 = num1 % 10;
      int z1 = num1 / 10;
      int sum1 = e1 + z1; // Einzelne Ziffern zusammenzaehlen
      System.out.println("Die Ziffernsumme von " + num1 + " betraegt " + sum1);
      
      // Dreistellige Zahl
      int e2 = num2 % 10;
      num2 = num2 / 10;
      int z2 = num2 % 10;
      num2 = num2 / 10;
      int h2 = num2 % 10;
      int sum2 = e2 + z2 + h2; // Einzelne Ziffern zusammenzaehlen
      System.out.println("Die Ziffernsumme von " + num2s + " betraegt " + sum2);
      
      // Vierstellige Zahl
      int e3 = num3 % 10;
      num3 = num3 / 10;
      int z3 = num3 % 10;
      num3 = num3 / 10;
      int h3 = num3 % 10;
      num3 = num3 / 10;
      int t3 = num3 % 10;
      int sum3 = e3 + z3 + h3 + t3; // Einzelne Ziffern zusammenzaehlen
      System.out.println("Die Ziffernsumme von " + num3s + " betraegt " + sum3);
   }
}