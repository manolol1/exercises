// projecteuler.net
// Problem 13
// Sum Square Difference

import java.util.*;
import java.io.*;
import java.math.*;

public class Euler_13 {
   public static void main(String[] args) {
      BigInteger sum = new BigInteger("0");
      
      try {
         File file = new File("input.txt");
         Scanner s = new Scanner(file);
         System.out.println("File read.");
         
         while (s.hasNextLine()) {
            String line = s.nextLine();
            sum = sum.add(new BigInteger(line));
         }
      } catch (Exception e) {
         System.out.println("Couldn't read file");
         System.exit(1);
      }
      
      
      System.out.println(sum.toString().substring(0, 10));
   }
   
}