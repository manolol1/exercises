/********************************************
* Name:           Mario Ebenhofer
* Datum:          10.01. 2024
* HUE:            13
* Bsp:            01
* Beschreibung:   Ampelphasen
*********************************************/

import java.util.Scanner;

public class EX_13_01_TrafficLight {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int numOfPhases = -1;
      int currPhase = 0;
      
      while (numOfPhases < 1) {
         System.out.print("Phasen: ");
         numOfPhases = s.nextInt();
         
         if (numOfPhases < 1) {
            System.out.println("Ungueltige Eingabe! Anzahl muss groesser als 0 sein.");
         }
      }
      
      for (int i = 0; i < numOfPhases; i++) {
         switch (currPhase) {
            case 0:
               System.out.println("Gruen");
               break;
            case 1:
               System.out.println("Gruen Blinkend");
               break;
            case 2:
               System.out.println("Gelb");
               break;
            case 3:
               System.out.println("Rot");
               break;
            case 4:
               System.out.println("Rot-Gelb");
               currPhase = -1;
               break;
         }
         currPhase++;
      }
   }
}