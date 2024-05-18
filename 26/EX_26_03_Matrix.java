/********************************************
* Name:          Mario Ebenhofer
* Date:          15.05. 2024
* HUE:           26
* EX:            03
* Description:   Matrix Methods
*********************************************/

import java.util.Arrays;

public class EX_26_03_Matrix {
   public static void main(String[] args) {
      final int ROWS = 5, COLS = 5;
      final int LB = 1, UB = 10;
      
      int[][] ma = new int[ROWS][COLS];
      fillMatrix(ma, LB, UB);
      printMatrix(ma);
      
      System.out.println(getRowSum(ma, 4));
      System.out.println(getColSum(ma, 4));
      System.out.println(getTotalSum(ma));
      System.out.println(getAverage(ma));
      System.out.println(getMinimum(ma));
      System.out.println(getMaximum(ma));
      System.out.println(getMostFrequentNum(ma));
      System.out.println(getMostFrequentCount(ma));
      System.out.println(Arrays.toString(getNumNotInMatrix(ma, LB, UB)));
   }
   
   private static void fillMatrix(int[][] ma, int lb, int ub) {
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            ma[i][j] = random(lb, ub);
         }
      }
   }
   
   private static void printMatrix(int[][] ma) {
      int min = getMinimum(ma);
      int max = getMaximum(ma);
      
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
   
   private static int getColSum(int[][] ma, int col) {
      if (col < 0 || col > ma.length - 1) {
         System.out.println("getRowSum() Error: row doesn't exist");
         return -1;
      }
      
      int sum = 0;
      
      for (int i = 0; i < ma[col].length; i++) {
         sum += ma[i][col];
      }
      
      return sum;
   }

   private static int getTotalSum(int[][] ma) {
      int sum = 0;
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            sum += ma[i][j];
         }
      }
   
      return sum;
   }
   
   // returns an array with a count of all possible numbers
   // count[count.length - 1] = offset
   private static int[] getCount(int[][] ma) {
      int min = getMinimum(ma);
      int max = getMaximum(ma);
      int offset = -min;
      
      int[] count = new int[max - min + 2];
      count[count.length - 1] = offset;
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length; j++) {
            count[ma[i][j] + offset]++;
         }
      }
      
      return count;
   }
   
   private static int getMostFrequentNum(int[][] ma) {
      int[] count = getCount(ma);
      int offset = count[count.length - 1];
      
      int mostFrequent = -1;
      int maxCount = 0;
   
      for (int i = 0; i < count.length; i++) {
         if (count[i] > maxCount) {
            maxCount = count[i];
            mostFrequent = i - offset;
         }
      }
      
      return mostFrequent;
   }
   
   private static int getMostFrequentCount(int[][] ma) {
      int[] count = getCount(ma);
      int offset = count[count.length - 1];
      
      int mostFrequent = -1;
      int maxCount = 0;
   
      for (int i = 0; i < count.length; i++) {
         if (count[i] > maxCount) {
            maxCount = count[i];
         }
      }
      
      return maxCount;
   }
   
   private static int[] getNumNotInMatrix(int[][] ma, int lb, int ub) {
      int[] result = new int[ub - lb + 1];
      int index = 0;
      boolean found = false;
      
      for (int i = lb; i < ub; i++) {
         found = false;
         for (int j = 0; j < ma.length && !found; j++) {
            for (int k = 0; k < ma[j].length && !found; k++) {
               if (ma[j][k] == i) {
                  found = true;
               }
            }
         }
         
         if (!found) {
            result[index] = i;
            index++;
         }
      }
      
      return shrinkArray(result, index);
   }
   
   private static int[] shrinkArray(int[] ar, int length) {
      if (length > ar.length) {
         return ar;
      }
      
      int[] newAr = new int[length];
      
      // copy old values into new array
      for (int i = 0; i < length; i++) {
         newAr[i] = ar[i];
      }
      
      return newAr;
   }

   private static double getAverage(int[][] ma) {
      return (double) getTotalSum(ma) / (ma.length * ma[0].length);
   }
   
   private static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
}