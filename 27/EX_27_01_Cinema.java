/********************************************
* Name:          Mario Ebenhofer
* Date:          21.05. 2024
* HUE:           27
* EX:            01
* Description:   Cinema Room
*********************************************/

public class EX_27_01_Cinema {
   public static void main(String[] args) {
      final int[] POSSIBLE_PRICES = {6, 7, 8, 9, 11};
      final int ROWS = 15, COLS = 18;
      
      int[][] room = randomRoom(ROWS, COLS, POSSIBLE_PRICES);
      
      printMatrix(room);
      
      System.out.println("Sum of row 5: " + getRowSum(room, 5));
      System.out.println("Visitors in row 5: " + countVisitorsInRow(room, 5));
   }
   
   private static int[][] randomRoom(int rows, int cols, int[] possiblePrices) {
      int[][] ma = new int[rows][cols];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            int random = random(0, possiblePrices.length);
            switch (random) {
               case 0:
                  ma[i][j] = 0;
                  break;
               default:
                  ma[i][j] = possiblePrices[random - 1];
            }
         }
      }
      
      return ma;
   }
   
   private static int getRowSum(int[][] ma, int row) {
      if (row < 0 || row > ma.length - 1) {
         System.out.println("getRowSum() Error: row doesn't exist");
         return -1;
      }
      
      int sum = 0;
      
      for (int i = 0; i < ma[row].length; i++) {
         sum += ma[row][i];
      }
      
      return sum;
   }
   
   private static int countVisitorsInRow(int[][] ma, int row) {
      if (row < 0 || row > ma.length - 1) {
         System.out.println("countVisitorsInRow() Error: row doesn't exist");
         return -1;
      }
      
      int count = 0;
      
      for (int i = 0; i < ma[row].length; i++) {
         if (ma[row][i] != 0) {
            count++;
         }
      }
      
      return count;
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
   
   // Calculates maximum number-length and prints Matrix
   private static void printMatrix(int[][] ma) {
      int min = getMinimum(ma);
      int max = getMaximum(ma);
      
      int maxRow = String.valueOf(ma.length).length();
      int maxCol = Math.max(String.valueOf(min).length(), String.valueOf(max).length());
      
      printMatrix(ma, maxRow, maxCol);
   }
   
   // Prints Matrix with a space between each column
   private static void printMatrix(int[][] ma, int maxRow, int maxCol) {
      StringBuilder s = new StringBuilder(maxRow * maxCol);
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            s.append(String.format("%" + (maxCol + 1) + "d", ma[i][j]));
         }
         s.append("\n");
      }
      
      System.out.println(s.toString());
   }
   
   private static int getMinimum(int[][] ma) {
      int min = ma[0][0];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            if (ma[i][j] < min) {
               min = ma[i][j];
            }
         }
      }
      
      return min;
   }
   
   private static int getMaximum(int[][] ma) {
      int max = ma[0][0];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            if (ma[i][j] > max) {
               max = ma[i][j];
            }
         }
      }
      
      return max;
   }

}
