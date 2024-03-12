/********************************************
* Name:           Mario Ebenhofer
* Datum:          11.10.2023
* HUE:            04
* Bsp:            01
* Beschreibung:   Gerade und Ungerade Zahlen
*********************************************/

import java.util.Scanner;

public class EX_04_01_EvenOdd{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in); // Scanner für die Eingabe erstellen
      
      System.out.println("****************************");
      System.out.println("Enter 0 to end the program.");
      System.out.println("****************************\n");
      while(true){ // Dauerschleife
         System.out.print("Enter a number: ");
         int num = s.nextInt();
         
         if(num == 0){
            System.out.println("\nProgram ended.");
            break;
         }
         
         if(num % 2 != 0){
            System.out.println(num + " is odd.");
         } else{
            System.out.println(num + " is even.");
         }
      }
   }
}