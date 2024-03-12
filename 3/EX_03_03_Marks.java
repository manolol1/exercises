/********************************************
* Name:           Mario Ebenhofer
* Datum:          04.10.2023
* HUE:            03
* Bsp:            03
* Beschreibung:   Note aus Punktezahl berechnen
*********************************************/

import java.util.Scanner;

public class EX_03_03_Marks{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      System.out.println("Enter -1 for a to end the program!\n");
      
      while(true){
         try{
            System.out.print("Points: ");
            Double points = s.nextDouble();
            
            if(points == -1){ // Programm beenden, wenn points == -1
               System.out.print("Program ended.");
               break;
            }
            
            if(points < 0 || points > 10){
               System.out.println("Invalid Input! The number must be between 0 and 10.");
               s.nextLine();
               continue;
            }
            
            if(points < 5){
               System.out.println("Not passed! (" + points + "/10)");
            }
            else if(points <= 7){
               System.out.println("Passed! (" + points + "/10)");
            } else{
                System.out.println("Excellent Pass! (" + points + "/10)");
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