/********************************************
* Name:          Mario Ebenhofer
* Date:          29.05. 2024
* HUE:           28
* EX:            03
* Description:   Sorting 2D-Arrays
* Common Methods: https://github.com/manolol1/JavaUtils
*********************************************/

import JavaUtils.*;

public class EX_28_03_MatrixSort {
   public static void main(String[] args) {
      int[][] ma = MatrixUtils.randomMatrix(5, 8, -100, 100);
      
      System.out.println("Unsorted:");
      MatrixUtils.printMatrix(ma);
      
      sortByRowSum(ma);
      System.out.println("Sorted by row sums:");
      MatrixUtils.printMatrix(ma);
      
      sortIndividualRows(ma);
      System.out.println("Sorted individual lines:");
      MatrixUtils.printMatrix(ma);
      
      sort(ma);
      System.out.println("Sorted completely:");
      MatrixUtils.printMatrix(ma);
   }

   /** Sort a matrix by row sums in ascending order using SelectionSort */
   // now also included in MatrixUtils
   public static void sortByRowSum(int[][] ma) {
      int minIndex;
      int[] temp;
      
      for (int i = 0; i < ma.length - 1; i++) {
         minIndex = i;
         
         // find new min index
         for (int j = i + 1; j < ma.length; j++) {
            if (MatrixUtils.getRowSum(ma, j) < MatrixUtils.getRowSum(ma, minIndex)) {
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
   // now also included in MatrixUtils
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
}