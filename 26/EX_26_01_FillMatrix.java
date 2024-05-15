/********************************************
* Name:          Mario Ebenhofer
* Date:          15.05. 2024
* HUE:           26
* EX:            01
* Description:   Fill and print Matrix
*********************************************/

public class EX_26_01_FillMatrix {
   public static void main(String[] args){
      int rows = 500, cols = 800;
      
      int maxRow = String.valueOf(rows).length();
      int maxCol = String.valueOf(rows * cols).length();
      
      int[][] ma = new int[rows][cols];
      
      fillMatrix(ma, 1);
      printMatrix(ma, maxRow, maxCol);
      System.out.println("\n");
      
      fillMatrix(ma, 2);
      printMatrix(ma, maxRow, maxCol);
      System.out.println("\n");
      
      fillMatrix(ma, 3);
      printMatrix(ma, maxRow, maxCol);
      System.out.println("\n");
      
      fillMatrix(ma, 4);
      printMatrix(ma, maxRow, maxCol);
      System.out.println("\n");
   }
   
   private static void fillMatrix(int[][] ma, int mode) {
      int ctr = 1;
      
      switch (mode) {
         case 1:
            for (int i = 0; i < ma.length; i++) {
               for (int j = 0; j < ma[i].length; j++) {
                  ma[i][j] = ctr;
                  ctr++;
               }
            }
            break;
         case 2:
            for (int i = 0; i < ma[0].length; i++) {
               for (int j = 0; j < ma.length; j++) {
                  ma[j][i] = ctr;
                  ctr++;
               }
            }
            break;
         case 3:
            for (int i = 0; i < ma.length; i++) {
               for (int j = ma[i].length - 1; j >= 0; j--) {
                  ma[i][j] = ctr;
                  ctr++;
               }
            }
            break;
         case 4:
            for (int i = 0; i < ma[0].length; i++) {
               for (int j = ma.length - 1; j >= 0; j--) {
                  ma[j][i] = ctr;
                  ctr++;
               }
            }
            break;
         default:
            System.out.println("Error: Invalid mode!");
            System.exit(1);
      }
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
}