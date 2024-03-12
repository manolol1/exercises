/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.12.2023
* HUE:            10
* Bsp:            02
* Beschreibung:   Gehalt von Politikern
*********************************************/

import java.util.Scanner;

public class EX_10_02_Salary {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      // Settings
      int baseIncome = 100000;
      int mpFlatRateMR = 40000;
      int mpFlatRateMRS = 50000;
      int normalSpeechIncome = 500;
      int extraSpeechIncome = 700;
      int secIncomePerH = 200;
      int normalSpeechLimit = 5;
      
      // Things to calculate
      int additionalSpeechesMR = 0;
      int additionalSpeechesMRS = 0;
      int speechSalaryMR = 0;
      int speechSalaryMRS = 0;
      int secSalary = 0;
      int totalSalary; 
      
      // User Input
      int speechesMR = 0;
      int hSecMR = 0;
      int speechesMRS = 0;
      int hSecMRS = 0;

      System.out.print("speechesMR: ");
      speechesMR = s.nextInt();
      System.out.print("hSecMR: ");
      hSecMR = s.nextInt();
      
      System.out.print("speechesMRS: ");
      speechesMRS = s.nextInt();
      System.out.print("hSecMRS: ");
      hSecMRS = s.nextInt();
      
      // Speeches
      if (speechesMR > normalSpeechLimit) {
         additionalSpeechesMR = speechesMR - normalSpeechLimit;
      }
      speechSalaryMR = (speechesMR - additionalSpeechesMR) * normalSpeechIncome + additionalSpeechesMR * extraSpeechIncome;
      
      if (speechesMRS > normalSpeechLimit) {
         additionalSpeechesMRS = speechesMRS - normalSpeechLimit;
      }
      speechSalaryMRS = (speechesMRS - additionalSpeechesMRS) * normalSpeechIncome + additionalSpeechesMRS * extraSpeechIncome;
      
      
      System.out.println(speechSalaryMR);
      System.out.println(speechSalaryMRS);
      
      // Secretary
      secSalary = (hSecMR + hSecMRS) * secIncomePerH;
      
      // Total
      totalSalary = baseIncome * 2 + mpFlatRateMR + mpFlatRateMRS + speechSalaryMR + speechSalaryMRS + secSalary;
      
      System.out.println("Das gemeinsame Gehalt von Herr und Frau Clever betraegt " + totalSalary);
   }
}