package JavaUtils;

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
   
   /** return smallest number in a matrix */
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
   
   /** return largest number in a matrix */
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
   
   /** return average of all values in a matrix */
   public static double getAverage(int[][] ma) {
      return (double) getTotalSum(ma) / getTotalLength(ma);
   }
   
   /** return total count of all elements in a matrix */
   public static int getTotalLength(int[][] ma) {
      int length = 0;
      
      for (int i = 0; i < ma.length; i++) {
         length += ma[i].length;
      }
      
      return length;
   }
   
   /** return sum of all numbers in a row */
   public static int getRowSum(int[][] ma, int row) {
      if (row < 0 || row > ma.length - 1) {
         System.out.println("MatrixUtils.getRowSum() Error: row doesn't exist");
         return -1;
      }
      
      return ArrayUtils.getSum(ma[row]);
      
   }
   
   /** return sum of all numbers in a column */
   public static int getColSum(int[][] ma, int col) {
      if (col < 0 || col > ma.length - 1) {
         System.out.println("MatrixUtils.getRowSum() Error: row doesn't exist");
         return -1;
      }
      
      int sum = 0;
      
      for (int i = 0; i < ma[col].length; i++) {
         sum += ma[i][col];
      }
      
      return sum;
   }

   /** return sum of all numbers in a matrix */
   public static int getTotalSum(int[][] ma) {
      int sum = 0;
      
      for (int i = 0; i < ma.length; i++) {
         sum += ArrayUtils.getSum(ma[i]);
      }
   
      return sum;
   }
   
   /** concatenate individual arrays from matrix into a single array */
   public static int[] toArray(int[][] ma) {
      int[] ar = new int[getTotalLength(ma)];
      int index = 0;
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ar[index++] = ma[i][j];
         }
      }
      
      return ar;
   }
   
   /** Sort a matrix by row sums in ascending order using SelectionSort */
   public static void sortByRowSum(int[][] ma) {
      int minIndex;
      int[] temp;
      
      for (int i = 0; i < ma.length - 1; i++) {
         minIndex = i;
         
         // find new min index
         for (int j = i + 1; j < ma.length; j++) {
            if (getRowSum(ma, j) < getRowSum(ma, minIndex)) {
               minIndex = j;
            }
         }
         
         // swap ma[i] and ma[minIndex]
         temp = ma[i];
         ma[i] = ma[minIndex];
         ma[minIndex] = temp;
      }      
   }
   
   /** Sort individual rows of a matrix in ascending order */
   public static void sortIndividualRows(int[][] ma) {
      for (int i = 0; i < ma.length; i++) {
         ArrayUtils.sort(ma[i]);
      }
   }
   
   /** sort matrix from left to right and top to bottom in ascending order */
   public static void sort(int[][] ma) {
      // copy matrix into single array and sort it
      int[] array = MatrixUtils.toArray(ma);
      ArrayUtils.sort(array);
      int index = 0;
      
      // overwrite values in matrix with sorted values
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ma[i][j] = array[index++];
         }
      }  
   }

   /** return last element of a matrix */
   public static int getLast(int[][] ma) {
      return ma[ma.length - 1][ma[ma.length - 1].length - 1];
   }
   
   /** set last element of a matrix to a value */
   public static void setLast(int[][] ma, int value) {
      ma[ma.length - 1][ma[ma.length - 1].length - 1] = value;
   }
   
   /** 
      return a new integer matrix, filled with random numbers 
      @param lb lowerBound (inclusive)
      @param ub upperBound (inclusive)
   */
   public static int[][] randomMatrix(int rows, int columns, int lb, int ub) {
      int[][] ma = new int[rows][columns];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ma[i][j] = JavaUtils.random(lb, ub);
         }
      }
      
      return ma;
   }
   
   /** 
      return a new integer matrix, filled with ascending numbers from left to right
      @param startNum first number (at ma[0][0])
   */
   public static int[][] ascendingMatrixLeftRight(int rows, int columns, int startNum) {
      int[][] ma = new int[rows][columns];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ma[i][j] = startNum++;
         }
      }
      
      return ma;
   }
   
   /** 
      return a new integer matrix, filled with ascending numbers from left to right (starting with 1)
   */
   public static int[][] ascendingMatrixLeftRight(int rows, int columns) {
      return ascendingMatrixLeftRight(rows, columns, 1);
   }

}
