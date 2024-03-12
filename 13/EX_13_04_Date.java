/********************************************
* Name:           Mario Ebenhofer
* Datum:          10.01. 2024
* HUE:            13
* Bsp:            04
* Beschreibung:   Datum gueltig oder ungueltig?
*********************************************/

import java.util.Scanner;

public class EX_13_04_Date {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int year = 2024;
      int month = 0;
      int day = 0;
      int maxDays = 31;
      
      boolean dateValid = true;
      
      String output = "";
      
      System.out.print("Tag: ");
      day = s.nextInt();
      
      System.out.print("Monat: ");
      month = s.nextInt();
      
      switch (month) {
         case 2:
            maxDays = 29;
            break;
         case 4:
         case 6:
         case 9:
         case 11:
            maxDays = 30;
      }
      
      dateValid = month < 1 || month > 12 || day < 1 || day > maxDays ? false : true;
      
      output = day + "." + month + ". " + year + " ist ";
      
      output += dateValid ? "gueltig" : "ungueltig";
      
      System.out.println(output);
   }
}