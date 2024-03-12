/********************************************
* Name:           Mario Ebenhofer
* Datum:          17.01. 2024
* HUE:            14
* Bsp:            01
* Beschreibung:   Datum gueltig oder ungueltig? Mit Schaltjahr.
*********************************************/

import java.util.Scanner;

public class EX_14_01_Date {
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      int year = 0;
      int month = 0;
      int day = 0;
      int maxDays = 31;
      int februaryDays = 28;
      
      boolean dateValid = true;
      
      String output = "";
      
      System.out.print("Tag: ");
      day = s.nextInt();
      
      System.out.print("Monat: ");
      month = s.nextInt();
      
      System.out.print("Jahr: ");
      year = s.nextInt();
      
      if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) februaryDays = 29;
      
      switch (month) {
         case 2:
            maxDays = februaryDays;
            break;
         case 4:
         case 6:
         case 9:
         case 11:
            maxDays = 30;
      }
      
      dateValid = month < 1 || month > 12 || day < 1 || day > maxDays ? false : true;
      
      output = "Der " + day + "." + month + "." + year + " ist ";
      output += dateValid ? "ein" : "kein";
      output += " gueltiges Datum.";
      
      System.out.println(output);
   }
}