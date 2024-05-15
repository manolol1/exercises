/********************************************
* Name:          Mario Ebenhofer
* Date:          15.05. 2024
* HUE:           26
* EX:            03
* Description:   Matrix Methods
*********************************************/

public class EX_26_03_Matrix {
   public static void main(String[] args){
      final int ROWS = 100, COLS = 200;
      final int LB = -99, UB = 99;
      
      int maxRow = String.valueOf(ROWS).length();
      int maxCol = Math.max(String.valueOf(LB).length(), String.valueOf(UB).length());
      
      int[][] ma = new int[ROWS][COLS];
      fillMatrix(ma, LB, UB);
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
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
}