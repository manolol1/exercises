/********************************************
* Name:           Mario Ebenhofer
* Datum:          12.02. 2024
* HUE:            16
* Bsp:            04
* Beschreibung:   String array
*********************************************/

public class EX_16_04_StringArray {
   public static void main(String[] args){
      String[] ar = {"Arrays", "einfach", "handhaben", "zu", "sind"};
      String[] arSorted = {ar[0], ar[4], ar[1], ar[3], ar[2]};
      
      System.out.println("Ungeordnet:\t" + arrayToString(ar));
      System.out.println("Geordnet:\t" + arrayToString(arSorted));
   }
   
   // combines an array of strings to a single string
   private static String arrayToString(String[] ar) {
      String str = "";
      
      str += ar[0];
      for (int i = 1; i < ar.length; i++) {
         str += (" " + ar[i]);
      }
      
      str += ".";
      
      return str;
   }
}