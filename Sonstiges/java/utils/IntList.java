// a very basic ArrayList-like integer list, which automatically resizes the internal array.

public class IntList {
   int[] ar;
   
   public IntList() {
      ar = new int[0];
   }
   
   public IntList(int[] array) {
      ar = array;
   }
   
   public void add(int n) {
      int[] temp = ar;
      ar = new int[ar.length + 1];
      
      for (int i = 0; i < temp.length; i++) {
         ar[i] = temp[i];
      }
      
      ar[temp.length] = n;
   }
   
   public void remove(int index) {
      int[] temp = ar;
      ar = new int[ar.length - 1];
      
      for (int i = 0; i < index; i++) {
         ar[i] = temp[i];
      }
      
      for (int i = index + 1; i < temp.length; i++) {
         ar[i - 1] = temp[i];
      }
   }
   
   public int get(int index) {
      return ar[index];
   }
   
   public int[] getArray() {
      return ar;
   }
}