package JavaUtils;

public class JavaUtils {
   /**
      returns a random number.
      @param lb lowerBound (inclusive)
      @param ub upperBound (inclusive)
   */
   public static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
}
