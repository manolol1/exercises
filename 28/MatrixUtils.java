public class MatrixUtils {
   
   /** Print a Matrix line by line with a "space" as a delimiter */
   public static void printMatrix(int[][] ma) {
      int min = getMinimum(ma);
      int max = getMaximum(ma);
      
      int maxRow = String.valueOf(ma.length).length();
      int maxCol = Math.max(String.valueOf(min).length(), String.valueOf(max).length());
      
      printMatrix(ma, maxRow, maxCol);
   }
   
   /** Print a Matrix line by line with a "space" as a delimiter.
       @param maxRow maximum possible length of a value in a row (required for correct formatting)
       @param maxCol maximum possible length of a value in a column (required for correct formatting)
   */
   public static void printMatrix(int[][] ma, int maxRow, int maxCol) {
      StringBuilder s = new StringBuilder(maxRow * maxCol);
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            s.append(String.format("%" + (maxCol + 1) + "d", ma[i][j]));
         }
         s.append("\n");
      }
      
      System.out.println(s.toString());
   }
   
   /** returns smallest number in a matrix */
   public static int getMinimum(int[][] ma) {
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
   
   /** returns largest number in a matrix */
   public static int getMaximum(int[][] ma) {
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
   
   /** returns sum of all numbers in a row */
   public static int getRowSum(int[][] ma, int row) {
      if (row < 0 || row > ma.length - 1) {
         System.out.println("MatrixUtils.getRowSum() Error: row doesn't exist");
         return -1;
      }
      
      int sum = 0;
      
      for (int i = 0; i < ma[row].length; i++) {
         sum += ma[row][i];
      }
      
      return sum;
   }

   
   /** returns a new integer matrix, filled with random numbers */
   public static int[][] randomMatrix(int rows, int columns, int lb, int ub) {
      int[][] ma = new int[rows][columns];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ma[i][j] = JavaUtils.random(lb, ub);
         }
      }
      
      return ma;
   }
}