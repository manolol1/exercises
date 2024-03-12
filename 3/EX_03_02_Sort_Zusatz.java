/********************************************
* Name:           Mario Ebenhofer
* Datum:          04.10.2023
* HUE:            03
* Bsp:            02
* Beschreibung:   Drei Zahlen sortieren (Zusatzaufgabe)
*********************************************/

import java.util.Scanner;

public class EX_03_02_Sort_Zusatz{
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
            
            System.out.print("c: ");
            double c = s.nextDouble();
            
            if(a == b && b == c){
               System.out.println("All three numbers have the same value!\n");
               continue; // Zurück zum Anfang der Schleife
            }
            
            if(a <= b && a <= c){
               System.out.print(a + ", "); // a ist die kleinste nummer
               
               if(b <= c){ // Reihenfolge von b und c herausfinden...
                  System.out.println(b + ", " + c);
               } else{
                  System.out.println(c + ", " + b);
               }
            }
            else if(b <= a && b <= c){
               System.out.print(b + ", "); // b ist die kleinste nummer
               
               if(a <= c){ // Reihenfolge von a und c herausfinden...
                  System.out.println(a + ", " + c);
               } else{
                  System.out.println(c + ", " + a);
               }
            
            } else{
               System.out.print(c + ", "); // c ist die kleinste nummer
               
               if(a <= b){ // Reihenfolge von a und b herausfinden...
                  System.out.println(a + ", " + b);
               } else{
                  System.out.println(b + ", " + a);
               }
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