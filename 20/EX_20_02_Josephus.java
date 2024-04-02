/********************************************
* Name:           Mario Ebenhofer
* Datum:          20.03. 2024
* HUE:            20
* Bsp:            02
* Beschreibung:   Personen entfernen
*********************************************/

public class EX_20_02_Josephus {
   public static void main(String[] args){
      int n = 8, p = 5;
      int personsLeft = n;
      int personsIndex = 0;
      boolean[] dead = new boolean[n];
      
      System.out.println("Anzahl der Personen (n): " + n);
      System.out.println("Streichungen (p): " + p);
      
      System.out.print("Entfernung der Personen: ");
      
      while (personsLeft > 0) {
         // jump to the next person to "remove"
         for (int i = 0; i < p - 1;) {
            if (!dead[personsIndex]) {
               i++;
            }
            personsIndex = (personsIndex + 1) % n;
         }
         
         // skip dead persons
         while (dead[personsIndex]) {
            personsIndex = (personsIndex + 1) % n;
         }
         
         dead[personsIndex] = true;
         personsLeft--;
         System.out.print((personsIndex + 1) + ((personsLeft != 0) ? " - " : ""));
      }
   }
}