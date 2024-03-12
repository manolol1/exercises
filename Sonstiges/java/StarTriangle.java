import java.util.Scanner;

public class StarTriangle {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int height = 0;
      String line = "";
      
      System.out.print("Hoehe: ");
      height = s.nextInt();
      
      while (height > 0) {
         line += "*";
         System.out.println(line);
         height--;
      }
   }
}