/********************************************
* Name:           Mario Ebenhofer
* Datum:          04.10.2023
* HUE:            03
* Bsp:            02
* Beschreibung:   Zwei Zahlen sortieren
*********************************************/

import java.util.Scanner;

public class EX_03_02_Sort{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      System.out.println("Enter 0 for a to end the program!\n");
      
      while(true){
         try{
            System.out.print("a: ");
            double a = s.nextDouble();
            
            if(a == 0){ // Programm beenden, wenn a == 0
               System.out.print("Program ended.");
               break;
            }
            
            System.out.print("b: ");
            double b = s.nextDouble();
            
            if(a == b){
               System.out.println("Both numbers have the same value!\n");
            }
            else if(a < b){
               System.out.println(a + ", " + b + "\n");
            } else{
               System.out.println(b + ", " + a + "\n");
            }
            
            // Wenn ein Fehler auftritt (z.B. Buchstabe als Eingabe), eine schönere Fehlermeldung anzeigen:
         } catch (Exception e){
            System.out.println("An error occured. This is most likely related to an invalid input. Make sure to only enter numbers!\n");
            System.out.println("Details: ");
            System.out.println(e);
            System.out.println("\nPlease restart the program to try again!");
            s.nextLine(); // Scanner "leeren", um eine Endlosschleife an Fehlermeldungen zu vermeiden
         }
      }
   }
}