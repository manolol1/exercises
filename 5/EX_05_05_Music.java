/*************************************************
* Name:           Mario Ebenhofer
* Datum:          18.10.2023
* HUE:            05
* Bsp:            05
* Beschreibung:   Musik-Anbieter Preis berechnen
**************************************************/

import java.util.Scanner;

public class EX_05_05_Music{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      // Grenzwerte
      int freeDownloads = 5;
      int normalDownloads = 30;
      
      // Preise
      int normalPrice = 20;
      int reducedPrice = 15;
      
      // Arbeitsvariablen
      int totalFee = 0;
      String feeText = "";
      int downloads;
      int downloadsLeft;
      
      System.out.print("Downloads: ");
      downloads = s.nextInt();
      
      downloadsLeft = downloads - freeDownloads;
      while(downloadsLeft > 0 && normalDownloads > 0){
         totalFee += normalPrice;
         downloadsLeft--;
         normalDownloads--;
      }
      while(downloadsLeft > 0){
         totalFee += reducedPrice;
         downloadsLeft--;
      }
      
      // Geldbetrag schoener darstellen
      if(totalFee == 0){
         feeText = "0 Euro";
      } else{
         if(totalFee > 100){
            feeText += totalFee/100 + ",";
            totalFee %= 100;
         } else{
            feeText = "0,";
         }
         if(totalFee < 9){
            feeText += "0";
         }
         feeText += totalFee + " Euro.";
      }
      
      System.out.println("Der Gesamtpreis fuer " + downloads + " betraegt " + feeText);
   }
}