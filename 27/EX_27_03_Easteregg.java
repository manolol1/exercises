/********************************************
* Name:          Mario Ebenhofer
* Date:          21.05. 2024
* HUE:           27
* EX:            03
* Description:   Finding Easteregg locations
*********************************************/

public class EX_27_03_Easteregg {
   public static void main(String[] args) {
      final int ROWS = 10, COLS = 10;
      
      int[][] ma = randomMatrix(ROWS, COLS, 0, 1);
      printMatrix(ma, 1, 1);
      
      // loop through matrix to check each possible number
      for (int i = 1; i < ROWS - 1; i++) {
         for (int j = 1; j < COLS - 1; j++) {
            if (countNeighbours(ma, i, j, 1) % 2 == 0) {
               System.out.printf("Ein Versteck ist in Zeile %d Spalte %d\n", i, j);
            }
         }
      }
   }
   
   // returns number of occurences of n next to ma[row][col] in a 2D-array
   private static int countNeighbours(int[][] ma, int row, int col, int n) {
      int count = 0;
      
      for (int i = row - 1; i <= row + 1; i++) {
         for (int j = col - 1; j <= col + 1; j++) {
            // ignore the number itself
            if (i == row && j == col) {
               continue;
            }
            
            if (ma[i][j] == n) {
               count++;
            }
         }
      }
      
      return count;
   }
   
   private static int[][] randomMatrix(int rows, int cols, int lb, int ub) {
      int[][] ma = new int[rows][cols];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ma[i][j] = random(lb, ub);
         }
      }
      
      return ma;
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
   
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

}
