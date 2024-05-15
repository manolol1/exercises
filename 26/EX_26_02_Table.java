/********************************************
* Name:          Mario Ebenhofer
* Date:          15.05. 2024
* HUE:           26
* EX:            02
* Description:   Matrix cleanup
*********************************************/

public class EX_26_02_Table {
   public static void main(String[] args){
      final int ROWS = 100, COLS = 200;
      final int LB = -99, UB = 99;
      
      int maxRow = String.valueOf(ROWS).length();
      int maxCol = Math.max(String.valueOf(LB).length(), String.valueOf(UB).length());
      
      int[][] ma = randomMatrix(ROWS, COLS, LB, UB);
      printMatrix(ma, maxRow, maxCol);
      
      cleanMatrix(ma);
      printMatrix(ma, maxRow, maxCol);
   }
   
   private static int[][] randomMatrix(int rows, int cols, int lb, int ub) {
      int[][] ma = new int[rows][cols];
      
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            ma[i][j] = random(lb, ub);
         }
      }
      
      return ma;
   }
   
   private static void cleanMatrix(int[][] ma) {
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            if (!String.valueOf(ma[i][j]).contains(String.valueOf(i + 1))) {
               ma[i][j] = -1; 
            }
         }
      }
   }
   
   private static void printMatrix(int[][] ma, int maxRow, int maxCol) {
      StringBuilder s = new StringBuilder(maxRow * maxCol);
      
      for (int i = 0; i < ma.length; i++) {
         s.append(String.format("Zeile %" + maxRow + "d: ", i + 1));
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