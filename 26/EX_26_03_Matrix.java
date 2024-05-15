/********************************************
* Name:          Mario Ebenhofer
* Date:          15.05. 2024
* HUE:           26
* EX:            03
* Description:   Matrix Methods
*********************************************/

public class EX_26_03_Matrix {
   public static void main(String[] args) {
      final int ROWS = 5, COLS = 5;
      final int LB = -5, UB = 5;
      
      int[][] ma = new int[ROWS][COLS];
      fillMatrix(ma, LB, UB);
      printMatrix(ma);
      
      System.out.println(getRowSum(ma, 4));
   }
   
   private static void fillMatrix(int[][] ma, int lb, int ub) {
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ma[i][j] = random(lb, ub);
         }
      }
   }
   
   private static void printMatrix(int[][] ma) {
      int min = minMatrix(ma);
      int max = maxMatrix(ma);
      
      int maxRow = String.valueOf(ma.length).length();
      int maxCol = Math.max(String.valueOf(min).length(), String.valueOf(max).length());
      
      printMatrix(ma, maxRow, maxCol);
   }
   
   private static void printMatrix(int[][] ma, int maxRow, int maxCol) {
      StringBuilder s = new StringBuilder(maxRow * maxCol);
      
      for (int i = 0; i < ma.length; i++) {
         //s.append(String.format("Zeile %" + maxRow + "d: ", i + 1));
         for (int j = 0; j < ma[i].length; j++) {
            s.append(String.format("%" + (maxCol + 1) + "d", ma[i][j]));
         }
         s.append("\n");
      }
      
      System.out.println(s.toString());
   }
   
   private static int minMatrix(int[][] ma) {
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
   
   private static int maxMatrix(int[][] ma) {
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
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
}