/********************************************
* Name:           Mario Ebenhofer
* Datum:          11.10.2023
* HUE:            06
* Bsp:            04
* Beschreibung:   Feststellen, ob Zahl eine Primzahl ist
*********************************************/

import java.util.Scanner;

public class EX_06_04_Prime{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      System.out.print("Number: ");
      int num = s.nextInt();
      int ctr = 2;
      boolean isPrime = true;
      
      if(num == 1 || num < 1){
         isPrime = false;
      } else{
         while(ctr <= Math.sqrt(num) && isPrime){
            if(num % ctr == 0){
               isPrime = false;
            } else{
               ctr++;
            }
         }
      }
      if(isPrime){
         System.out.println(num + " ist eine Primzahl");
      } else{
         System.out.println(num + " ist keine Primzahl");
      }
   }
}