/********************************************
* Name:           Mario Ebenhofer
* Datum:          28.02. 2024
* HUE:            17
* Bsp:            04
* Beschreibung:   Wuerfeln mit mehreren Wuerfeln
* Auffaelligkeit: Besonders bei Verwendung von mehreren Wuerfeln liegt die
                  Verteilung der Wuerfe sehr stark in der Mitte.
                  Der Grund dafuer ist vermutlich, dass es bei sehr kleinen oder
                  grossen Zahlen oft nur eine wenige Moeglichkeiten gibt,
                  diese zu wuerfeln. Bei den Zahlen in der Mitte
                  gibt es oft mehrere moegliche Kombinationen der Wuerfel.
                  Beispiel:
                  Bei 2 Wuerfeln ist die einzige Moeglichkeit, die Zahl 2 zu bekommen,
                  dass beide Wuerfel 1 wuerfeln. Die Zahl 7 hingegen laesst sich durch
                  sehr viele Kombinationen erzeugen: 3-4, 4-3, 2-5, 1-6, ....
*********************************************/

public class EX_17_04_DiceII {
   public static void main(String[] args){
      final int LB = 1, UB = 6; // per dice
      final int DICES = 100;
      final int ROLLS = 10_000_000;
      
      int[] counter = new int[(UB - LB + 1) * DICES + 1];
      
      // roll dices
      for (int i = 0; i < ROLLS; i++) {
         int tempRoll = 0;
         for (int j = 0; j < DICES; j++) {
            tempRoll += roll(LB, UB);
         }
         counter[tempRoll - DICES * LB]++;
      }
      
      // output
      System.out.println("Gesamtwuerfe: " + ROLLS);
      System.out.println("Anzahl der Wuerfel: " + DICES);
      
      for (int i = DICES * LB; i <= DICES * UB; i++) {
         System.out.printf("%3d: %8d\t\t%s\n", i, counter[i - DICES * LB], numberAsBar(counter[i - DICES * LB]));
      }
   }
   
   private static int roll(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
   
   private static String numberAsBar(int n) {
      StringBuilder result = new StringBuilder(n);
      for (int i = 0; i < n; i++) {
         result.append("|");
      }
      return result.toString();
   }
}