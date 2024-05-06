public class Change {
   public static void main(String[] args) {
      int a = 10;
      a = change(a, 3);
      System.out.println(a);
   }
   
   private static int change(int x, int y) {
      return x + y;
   }
}