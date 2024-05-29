public class JavaUtils {
   /** returns a random number. lb and ub are inclusive. */
   public static int random(int lb, int ub) {
      return (int) (Math.random() * (ub - lb + 1) + lb);
   }
}