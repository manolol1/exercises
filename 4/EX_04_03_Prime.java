/********************************************
* Name:           Mario Ebenhofer
* Datum:          11.10.2023
* HUE:            04
* Bsp:            03
* Beschreibung:   Feststellen, ob Zahl eine Primzahl ist
*********************************************/

import java.util.Scanner;
import java.lang.Math;

public class EX_04_03_Prime{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      System.out.print("Number: ");
      int num = s.nextInt();
      int ctr = 2;
      boolean isPrime = true;
      
      while(ctr <= Math.sqrt(num)){
         if(num % ctr == 0){
            isPrime = false;
            break; // Schleife beenden
         } else{
            ctr++;
         }
      }
      if(isPrime){
         System.out.println(num + " ist eine Primzahl");
      } else{
         System.out.println(num + " ist keine Primzahl");
      }
   }
}