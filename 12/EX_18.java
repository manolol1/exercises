// Hausübung 12
// Aufgabe 18
// Mario Ebenhofer

import java.util.Scanner;

public class EX_18 {

   public static void main(String[] args) {
      /* Aufgabe 18 */
      {
         int t1 = 172200;
         int t2 = 184500;
         int diff = 0;
         
         int t1Second, t1Minute, t1Hour;
         int t2Second, t2Minute, t2Hour;
         int diffSecond, diffMinute, diffHour;
         
         String t1S, t2S, diffS;
       
         // Parse t1
         if (t1 <= 99) {
            t1Hour = 0;
            t1Minute = 0;
            t1Second = t1;
         }
         else if (t1 <= 9999) {
            t1Hour = 0;
            t1Minute = t1 / 100 % 100;
            t1Second = t1 % 100;
         } else {
            t1Hour = t1 / 10000 % 100;
            t1Minute = t1 / 100 % 100;
            t1Second = t1 % 100;
         }
         
         // Parse t2
         if (t2 <= 99) {
            t2Hour = 0;
            t2Minute = 0;
            t2Second = t2;
         }
         else if (t2 <= 9999) {
            t2Hour = 0;
            t2Minute = t2 / 100 % 100;
            t2Second = t2 % 100;
         } else {
            t2Hour = t2 / 10000 % 100;
            t2Minute = t2 / 100 % 100;
            t2Second = t2 % 100;
         }
         
         // Check for invalid input
         if (t1Hour > 60 || t1Minute > 60 || t1Second > 60 ||
             t2Hour > 60 || t2Minute > 60 || t2Second > 60) {
            System.out.println("Invalid Input.");
            System.out.println("Hours, Minutes and Seconds cannot be greater than 60.");
            System.exit(0);
         }
          
         t1S = String.format("%02d:%02d:%02d", t1Hour, t1Minute, t1Second);
         t2S = String.format("%02d:%02d:%02d", t2Hour, t2Minute, t2Second);
          
         if (t1 > t2) {
            if (t1Second < t2Second) {
               t1Minute--;
               t1Second += 60;
            }
            diffSecond = t1Second - t2Second;
            
            if (t1Minute < t2Minute) {
               t1Hour--;
               t1Minute += 60;
            }
            diffMinute = t1Minute - t2Minute;
            
            diffHour = t1Hour - t2Hour;
         } else {
            if (t2Second < t1Second) {
               t2Minute--;
               t2Second += 60;
            }
            diffSecond = t2Second - t1Second;
            
            if (t2Minute < t1Minute) {
               t2Hour--;
               t2Minute += 60;
            }
            diffMinute = t2Minute - t1Minute;
            
            diffHour = t2Hour - t1Hour;
         }
         
         diffS = String.format("%02d:%02d:%02d", diffHour, diffMinute, diffSecond);
         
         System.out.println("Zeit1:\t\t\t" + t1S);
         System.out.println("Zeit2:\t\t\t" + t2S);
         System.out.println("Differenz:\t\t" + diffS);
      }
   }
}