/*************************************************
* Name:           Mario Ebenhofer
* Datum:          18.10.2023
* HUE:            05
* Bsp:            03
* Beschreibung:   Drei Zahlen sortieren
**************************************************/

import java.util.Scanner;

public class EX_05_03_Sort{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int num1;
      int num2;
      int num3;
      
      // Eingabe
      System.out.print("Erste Zahl: ");
      num1 = s.nextInt();
      System.out.print("Zweite Zahl: ");
      num2 = s.nextInt();
      System.out.print("Dritte Zahl: ");
      num3 = s.nextInt();

      // Wenn num1 die kleinste Zahl ist:
      if(num1 <= num2 && num1 <= num3){
         System.out.print(num1 + ", ");
         // Weitere Reihenfolge überprüfen und ausgeben:
         if(num2 < num3){
            System.out.print(num2 + ", " + num3);
         } else{
            System.out.print(num3 + ", " + num2);
         }
      }
      // Wenn num2 die kleinste Zahl ist:
      else if(num2 <= num1 && num2 <= num3){
         System.out.print(num2 + ", ");
         // Weitere Reihenfolge überprüfen und ausgeben:
         if(num1 < num3){
            System.out.print(num1 + ", " + num3);
         } else{
            System.out.print(num3 + ", " + num1);
         }
      }
      // Wenn num3 die kleinste Zahl ist:
      else if(num3 <= num1 && num3 <= num2){
         System.out.print(num3 + ", ");
         // Weitere Reihenfolge überprüfen und ausgeben:
         if(num1 < num2){
            System.out.print(num1 + ", " + num2);
         } else{
            System.out.print(num2 + ", " + num1);
         }
      }
   }
}