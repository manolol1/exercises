/********************************************
* Name:           Mario Ebenhofer
* Datum:          20.03. 2024
* HUE:            20
* Bsp:            03
* Beschreibung:   Mathematische Wahrscheinlichkeit
*********************************************/

public class EX_20_03_Birthday {
   public static void main(String[] args){
      final int ATTEMPTS = 1000000;
      final int[] STUDENTS = {10, 20, 23, 29, 30, 40, 50, 60, 70, 80, 90,100};
      
      System.out.println("Anzahl der Versuche:  " + ATTEMPTS + "\n");
      
      System.out.println("Schuelerzahl\t\tAnzahl doppelt\t\tWahrscheinlichkeit");
      
      for (int i = 0; i < STUDENTS.length; i++) {
         int duplicates = 0;
         double percent;
         
         for (int j = 0; j < ATTEMPTS; j++) {
            if (simulateBirthdays(STUDENTS[i])) {
               duplicates++;
            }
         }
         
         percent = (double) (duplicates * 100) / ATTEMPTS;
         
         System.out.printf("%-17d%6d / %-10d%.2f%%\n",STUDENTS[i], duplicates, ATTEMPTS, percent);
      }
   }
   
   private static boolean simulateBirthdays(int students) {
      int[] birthdates = new int[students];
      
      for (int i = 0; i < students; i++) {
         birthdates[i] = randomNum(1, 365);
         
         for (int j = 0; j < i; j++) {
            if (birthdates[i] == birthdates[j]) {
               return true;
            }
         }
      }
      
      return false;
   }
   
   private static int randomNum(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1)) + lb;
   }
}