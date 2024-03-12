/********************************************
* Name:           Mario Ebenhofer
* Datum:          06.03. 2024
* HUE:            18
* Bsp:            01
* Beschreibung:   Zahlen an Personen zuweisen und so.
*********************************************/

public class EX_18_01_ProfitPerson {
   public static void main(String[] args){
      final int LB = 10, UB = 100;
      
      String[] names = {"Peter", "Max", "Lisa", "Peter", "Konrad", "Sara", "Sara", "Peter", "Stefan", "Max"};
      int[] prices = new int[names.length];
      boolean[] nameDuplicate = new boolean[names.length];
      int maxPerson = 0;
      int minPerson = 0;
      int averagePrice = 0;
      int longestName = 0;
      
      // fill prices
      for (int i = 0; i < prices.length; i++) {
         prices[i] = (int) (Math.random() * (UB - LB + 1) + LB);
      }
      
      // calculate max and average price
      for (int i = 0; i < prices.length; i++) {
         if (prices[i] > prices[maxPerson]) {
            maxPerson = i;
         }
         if (prices[i] < prices[minPerson]) {
            minPerson = i;
         }
         averagePrice += prices[i];
      }
      averagePrice /= prices.length;
      
      // find longest name
      for (String name : names) {
         if (name.length() > longestName) {
            longestName = name.length();
         }
      }
            
      // output
      System.out.println("[Alle Personen]");
      for (int i = 0; i < names.length; i++) {
         System.out.printf("%-" + (longestName + 1) + "s %" + String.valueOf(UB).length() + "d | ", names[i] + ":", prices[i]);
         System.out.println(prices[i] > averagePrice ? "> Durschnitt" : "<= Durchschnitt");
      }
      
      System.out.println("\nHoechster Gewinn: " + names[maxPerson] + " (" + prices[maxPerson] + ")");
      System.out.println("Niedrigster Gewinn: " + names[minPerson] + " (" + prices[minPerson] + ")");
      System.out.println("Differenz: " + (prices[maxPerson] - prices[minPerson]));
      System.out.println("Durschnittlicher Gewinn: " + averagePrice);
      
      System.out.println("\n[gleichnamige Personen]");
      for (int i = 0; i < names.length; i++) {
         for (int j = i + 1; j < names.length; j++) {
            if (names[i].equals(names[j])) {
               if (!nameDuplicate[i]) {
                  nameDuplicate[i] = true;
                  System.out.println(names[i] + ": " + prices[i]);
               }
               if (!nameDuplicate[j]) {
                  nameDuplicate[j] = true;
                  System.out.println(names[j] + ": " + prices[j]);
               }
            }
         }
      } 
   }
}