import java.time.LocalDate;
import java.util.Scanner;

public class Main {
   /* void printRuler(int consoleWidth, int tickSpacing) */
   public static int CONSOLE_WIDTH = 80;  // Konsole: 80 Zeichen/Zeile
   public static int TICK_SPACING = 6;    // Linealmarkierung alle 5 Spalten

   /* void printReceipt() */
   public static int RECEIPT_WIDTH = 38;  // Zeichenbreite der auszugebenden Rechnung
   public static String[] product = {     // Array der auszugebenden Produkte
         "SanLucar Erdbeeren 400g",
         "Simply Good Dressing",
         "Salatschale Mais",
         "Clever Vanillejoghurt",
         "Clever Schlagobers 36%",
         "Clever Eierspätzle",
         "Clever Bratwürstel dünn",
         "Tomatenmark in der Dose",
      };
   public static int[] quantity = {       // Array der zugehörigen Produktmengen
         1, 2, 2, 15, 2, 1, 117, 2
      };
   public static double[] itemPrize = {   // Array der zugehörigen Einzelstückpreise
         3.49, 1.49, 2.19, 0.45, 1.39, 3.98, 3.99, 1.09
      };

   /* Program entry point: */
   public static void main(String[] args) {
      boolean showMenu = true;  /* show selection menu? */
      int exercise = -1;

      assert product.length == quantity.length && product.length == itemPrize.length
           : "Shopping cart entries must match";
      System.out.println("Printf for fun and profit:");

      /* Any command line arguments? */
      if (args.length == 1) {
         try {
            exercise = Integer.parseInt(args[0]);
            showMenu = false;
         } catch (NumberFormatException e) {
            printUsage();
            System.exit(1);
         }
      }

      /* Otherwise, print a boring text-based menu: */
      Scanner sc = new Scanner(System.in);

      do {
         if (showMenu) {
            System.out.println();
            System.out.println("1 ... print progress bar");
            System.out.println("2 ... print ruler");
            System.out.println("3 ... print supermarket receipt");
            System.out.println("4 ... quit application");
            System.out.print("\nWhich exercise?  ");
            exercise = sc.nextInt();
            showMenu = (exercise != 4);
         }

         if (exercise >= 1 && exercise <= 3) {
            printSeparator();
         }
         switch(exercise) {
            case 1: printProgressBar(3.70); break;
            case 2: printRuler(CONSOLE_WIDTH, TICK_SPACING); break;
            case 3: printReceipt(product, quantity, itemPrize); break;
         }
      } while (showMenu);
   }

   /* Ausgabe Hilfetext zur Nutzung in der Konsole. */
   public static void printUsage() {
      System.err.println("Usage:");
      System.err.println("java Ex01_PrintfReceipt <exercise-number>\n");
      System.err.println("E.g.:");
      System.err.println("java Ex01_PrintfReceipt 1  # print ruler");
      System.err.println("java Ex01_PrintfReceipt 2  # print progress bar");
      System.err.println("java Ex01_PrintfReceipt 3  # print supermarket receipt");
   }

   /* Ausgabe einer (80 Spalten breiten) Trennzeile */
   public static void printSeparator() {
      System.out.println("________________________________________________________________________________");
   }


/***********************************************************************
 *  Gibt in der Konsole eine Fortschrittsanzeige aus die von 0.00%
 *  bis 100.00% läuft, wobei dieser Fortschritt alle 100 Millisekunden
 *  um ‘stepSize’ Prozent zu erhöhen ist:
 *  Operation progress:    0.00%
 *  Operation progress:    3.70%  # 100ms später
 *     ⋮          ⋮
 *  Operation progress:  100.00%  # 2,7s später
 *  <p>Anmerkung: nach der Funktion sollte der Cursor in der Konsole
 *  am Beginn der nächsten Zeile stehen.</p>
 *  @param stepSize  Argument das angibt, um wieviele Prozent der
 *                   Fortschritt pro Iteration zu erhöhen ist.
 ***********************************************************************/
   public static void printProgressBar(double stepSize) {
      double progress = 0.0f;

      while (progress < 100) {
         progress += stepSize;

         if (progress >= 100) {
            progress = 100.0f;
         }

         System.out.printf("\rOperation progress: %7.2f%%", progress);
         System.out.flush();

         sleep(100);
      }

      System.out.println();
   }


/***********************************************************************
 *  Gibt über die gesamte Breite der aktuellen Zeile in der Konsole
 *  Linealmarkierungen aus. Der Spaltenindex selbst ist dabei alle
 *  ‘tickSpacing’ Spalten auszugeben. Sofern der Spaltenindex durch
 *  (2*tickSpacing) ohne Rest teilbar ist, soll auf den Spalteindex
 *  ein | (“Broken Bar”) folgen, andernfalls nur ein : (“Colon”).
 *  <p>Anmerkung: nach der Funktion sollte der Cursor in der Konsole
 *  am Beginn der nächsten Zeile stehen.</p>
 *  @param consoleWidth  Bildschirmspalte, bis zu der die Linealmarkie=
 *                       rungen ausgegeben werden sollen (default: 80).
 *  @param tickSpacing   Bildschirmspalten zwischen aufeinanderfolgenden
 *                       Linealmarkierungen (default: 5, muss ≥4 sein).
 ***********************************************************************/
   public static void printRuler(int consoleWidth, int tickSpacing) {
      for (int i = tickSpacing; i <= consoleWidth; i += tickSpacing) {
         int nLength = ("" + i).length();

         char ch = (i % (tickSpacing * 2) == 0) ? '|' : ':';

         System.out.printf("%" + (tickSpacing - 1) + "d%c", i, ch);
      }

      System.out.println();
   }


/***********************************************************************
 *  Liefert ein 3-elementiges Array zurück, in dem sich der Tag,
 *  das Monat sowie das Jahr des aktuellen Tagesdatums findet.
 *  @return  new int[] {day, month, year};
 ***********************************************************************/
   public static int[] today() {
      LocalDate currentDate = LocalDate.now();

      int[] today = new int[] {
            currentDate.getDayOfMonth(),
            currentDate.getMonth().getValue(),
            currentDate.getYear()
         };

      return (today);
   }

   public static String todayString() {
      return String.format("%02d.%02d.%4d", today()[0], today()[1], today()[2]);
   }

/***********************************************************************
 *  Gibt einen “SUPERMARKET” Einkaufszettel in der Konsole in gewohnter
 *  Art und Weise so aus, dass pro Textzeile neben dem Bezeichner eines
 *  jeden Produkts der Einzelstückpreis, die gewählte Anzahl (sowie am
 *  Ende der Ausgabe die sich ergebende Gesamtsumme) ausgegeben wird.
 *  <p>Anmerkung: nach der Funktion sollte der Cursor in der Konsole
 *  am Beginn der nächsten Zeile stehen.</p>
 *  @param product    Array der auszugebenden Produktbezeichner.
 *  @param quantity   Array der gewählten Produktmengen.
 *  @param itemPrize  Array der Einzelstückpreise dieser Produkte.
 ***********************************************************************/
   public static void printReceipt(String[] product, int[] quantity, double[] itemPrize) {
      final int QUANTITY_SPACE = 4, PRICE_SPACE = 8;

      final int NAME_SPACE = RECEIPT_WIDTH - QUANTITY_SPACE - PRICE_SPACE - 4;

      String headline = "SUPERMARKET";

      // center headline as well as possible
      headline = " ".repeat((Math.max((RECEIPT_WIDTH - headline.length()) / 2, 0))) + headline;
      System.out.println(headline);

      // underline headline
      System.out.println("-".repeat(RECEIPT_WIDTH));

      // date
      System.out.printf("Datum: %s%n%n", todayString());

      // print items
      for (int i = 0; i < product.length; i++) {
         System.out.printf("%-1." + NAME_SPACE + "s  %" + QUANTITY_SPACE + "d  %" + PRICE_SPACE + ".2f%n", product[i], quantity[i], itemPrize[i]);
      }
   }


/***********************************************************************
 * Hält die Programmausführung für ‘ms’ Millisekunden an. Anstelle
 * eines CPU-intensiven "busy waiting" wird die Aufgabe des eigentlichen
 * Wartens dabei an die statische Methode ‘sleep()’ der Thread-Klasse
 * übertragen. Im verwiesenen Blogbeitrag findet sich eine Erklärung,
 * weshalb Thread.currentThread().interrupt(); in der Regel eine gute
 * Idee ist.
 *  @param ms   Anzahl der zu wartenden Millisekunden.
 *  @see <a href="https://www.javaspecialists.eu/archive/Issue056-Shutting-down-Threads-Cleanly.html">Shutting down Threads Cleanly</a>
 ***********************************************************************/
   public static void sleep(int ms)
   {
      try {
         Thread.sleep(ms);
      }
      catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
   }
};
