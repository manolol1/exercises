package JavaUtils;

public class ArrayUtils {
   /**
    return a new integer array, filled with random numbers
    @param lb lowerBound (inclusive)
    @param ub upperBound (inclusive)
    */
   public static int[] randomArray(int length, int lb, int ub) {
      int[] ar = new int[length];

      for (int i = 0; i < ar.length; i++) {
         ar[i] = JavaUtils.random(lb, ub);
      }

      return ar;
   }

   /** print an array, with the values seperated by a delimiter */
   public static void printArray(int[] ar, String delimiter) {
      System.out.println(toString(ar, delimiter));
   }

   /** print an array, with the values seperated by a space */
   public static void printArray(int[] ar) {
      System.out.println(toString(ar));
   }

   /** format an array as a String, with the values seperated by a space */
   public static String toString(int[] ar) {
      return toString(ar, " ");
   }

   /** format an array as a String, with the values seperated by a delimiter */
   public static String toString(int[] ar, String delimiter) {
      StringBuilder sb = new StringBuilder(ar.length + ar.length * delimiter.length());

      sb.append(ar[0]);

      for (int i = 1; i < ar.length; i++) {
         sb.append(delimiter).append(ar[i]);
      }

      return sb.toString();
   }

   /** Sort and Array in ascending order */
   public static void sort(int[] ar) {
      selectionSort(ar);
   }

   /** Sort an Array in ascending order using SelectionSort */
   public static void selectionSort(int[] ar) {
      int minIndex, temp;

      for (int i = 0; i < ar.length - 1; i++) {
         minIndex = i;

         // find minIndex
         for (int j = i + 1; j < ar.length; j++) {
            if (ar[j] < ar[minIndex]) {
               minIndex = j;
            }
         }

         // swap
         temp = ar[i];
         ar[i] = ar[minIndex];
         ar[minIndex] = temp;
      }
   }

   /** return total sum of an array */
   public static int getSum(int[] ar) {
      int sum = 0;

      for (int n : ar) {
         sum += n;
      }

      return sum;
   }

   /**
    * Create a new array with a value appended at the end
    * @param ar original array
    * @param value the value that will be appended to the array
    * @return new (ar.length + 1 long) array with the appended value
    */
   public static int[] append(int[] ar, int value) {
      int[] newAr;

      if (ar == null || ar.length == 0) {
         newAr = new int[1];
      } else {
         newAr = new int[ar.length + 1];
         arrayCopy(ar, newAr);
      }

      newAr[newAr.length - 1] = value;

      return newAr;
   }

   /**
    * Create a new array with a value prepended at the beginning
    * @param ar original array
    * @param value the value that will be prepended to the array
    * @return new (ar.length + 1 long) array with the prepended value
    */
   public static int[] prepend(int[] ar, int value) {
      int[] newAr;

      if (ar == null || ar.length == 0) {
         newAr = new int[1];
      } else {
         newAr = new int[ar.length + 1];
         arrayCopy(ar, newAr, 1);
      }

      newAr[0] = value;

      return newAr;
   }

   /**
    * Copy ar1 into ar2
    * @param ar1 original array
    * @param ar2 array to copy into
    */
   public static void arrayCopy(int[] ar1, int[] ar2) {
      arrayCopy(ar1, ar2, 0);
   }

   /**
    * Copy ar2 into ar1 at a specific position
    * @param ar1 original array
    * @param ar2 array to copy into
    * @param startIndex startIndex where at2 starts
    */
   public static void arrayCopy(int[] ar1, int[] ar2, int startIndex) {
      if (ar1 != null) {
         for (int i = startIndex; i < ar1.length + startIndex && i < ar2.length; i++) {
            ar2[i] = ar1[i - startIndex];
         }
      }
   }

   /**
    * Delete a value from an array
    * @param ar array to delete in
    * @param index index of value to delete - if index > ar.length, the last position will be removed.
    * @return new array with the value removed
    */
   public static int[] delete(int[] ar, int index) {
      int[] newAr;

      if (ar == null || ar.length == 0) {
         newAr = new int[1];
      } else {
         newAr = new int[ar.length - 1];

         int indexOld = 0, indexNew = 0;

         while (indexOld < ar.length && indexNew < newAr.length) {
            // skip position that should be deleted
            if (indexOld == index) {
               indexOld++;
            }

            newAr[indexNew] = ar[indexOld];

            indexOld++;
            indexNew++;
         }
      }

      return newAr;
   }

    /**
     * Insert a value into an array
     * @param ar array to insert in
     * @param index index where the value should be inserted - if index > ar.length, the value will be appended at the end.
     * @param value value to insert
     * @return new array with the value inserted
     */
    public static int[] insert(int[] ar, int index, int value) {
       int[] newAr;

       if (ar == null || ar.length == 0) {
          newAr = new int[1];
          newAr[0] = value;
       } else {
          if (index >= ar.length) {
             return append(ar, value);
          }

          newAr = new int[ar.length + 1];
          int indexOld = 0, indexNew = 0;

          while (indexOld < ar.length && indexNew < newAr.length) {
             if (indexNew == index) {
                newAr[indexNew] = value;
                indexNew++;
             } else {
                newAr[indexNew] = ar[indexOld];
                indexOld++;
                indexNew++;
             }
          }
       }

       return newAr;
    }

    /**
     * Delete all occurrences of a value from an array
     * @param ar array to delete in
     * @param value value to delete
     * @return new array with all occurrences of the value removed
     */
    public static int[] deleteAll(int[] ar, int value) {
       int[] newAr = new int[ar.length];
       arrayCopy(ar, newAr);

       int indexNew = 0;

       for (int i : ar) {
          if (i != value) {
             newAr[indexNew] = i;
             indexNew++;
          }
       }

       int[] resizedAr = new int[indexNew];
       arrayCopy(newAr, resizedAr);

       return resizedAr;
    }
}