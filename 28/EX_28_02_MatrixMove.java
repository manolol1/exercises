/********************************************
* Name:          Mario Ebenhofer
* Date:          29.05. 2024
* HUE:           28
* EX:            02
* Description:   
*********************************************/

import java.util.Scanner;
import JavaUtils.*;

public class EX_28_02_MatrixMove {
   public static void main(String[] args) {
      int[][] ma = MatrixUtils.ascendingMatrixLeftRight(6, 8);
   
      System.out.println("Initial Matrix:");
      MatrixUtils.printMatrix(ma);
      
      System.out.println("right:");
      shiftRight(ma);
      MatrixUtils.printMatrix(ma);
      
      System.out.println("left:");
      shiftLeft(ma);
      MatrixUtils.printMatrix(ma);
   }
   
   public static void shiftRight(int[][] ma) {
      int temp = MatrixUtils.getLast(ma);
      
      for (int i = ma.length - 1; i >= 0; i--) {
         for (int j = ma[i].length - 1; j > 0; j--) {
            ma[i][j] = ma[i][j - 1];
         }
         
         if (i > 0) {
            ma[i][0] = ma[i - 1][ma[i - 1].length - 1];
         } else {
            ma[0][0] = temp;
         }
      }
   }
   
   public static void shiftLeft(int[][] ma) {
      int temp = ma[0][0];
      
      for (int i = 0; i < ma.length; i++) {
         for (int j = 0; j < ma[i].length - 1; j++) {
            ma[i][j] = ma[i][j + 1];
         }
         
         if (i < ma.length - 1) {
            ma[i][ma[i].length - 1] = ma[i + 1][0];
         } else {
            ma[i][ma[i].length - 1] = temp;
         }
      }
   }
}
