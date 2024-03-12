import java.util.Scanner;

public class HelloWorld {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      String name; // Variable (Platzhalter für Zahl, Buchstaben, Wörter, ...)
      
      System.out.print("Name: "); // Text Ausgeben
      name = s.nextLine(); // Benutzereingabe
      
      System.out.println("Hallo " + name + "!"); // Text ausgeben und Variable "einsetzen"
   }
}