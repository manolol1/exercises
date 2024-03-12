/***********************************************************
* Name:           Mario Ebenhofer
* Datum:          08.11.2023
* HUE:            07
* Bsp:            01
* Beschreibung:   Zahlen jeweils in zweiter und dritter Potenz ausgeben
************************************************************/

import java.util.Scanner;

public class Ex_07_01_Table {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int lb = 0;
      int ub = 0;
      int ctr = 0;
      boolean inputPending = true;
      
      // User Input
      while (inputPending) {
         System.out.print("lowerBound: ");
         lb = s.nextInt();
         System.out.print("upperBound: ");
         ub = s.nextInt();
         
         if (ub <= lb) {
            System.out.println("lowerBound must be greater than upperBound!");
            System.out.println("Please try again.\n");
         } else {
            inputPending = false;
         }
      }
      
      ctr = lb;
      
      System.out.println("Zahl\t\t\tQuadrat\t\t\tKubik");  
       
      while (ctr <= ub) {
         System.out.print(ctr);
         System.out.print("\t\t\t\t" + ctr*ctr);
         System.out.print("\t\t\t\t\t" + ctr*ctr*ctr);
         System.out.println();
         ctr++;
      }    
   }
}