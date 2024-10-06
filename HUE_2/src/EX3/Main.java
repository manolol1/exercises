package EX3;

/********************************************
 * Name:          Mario Ebenhofer
 * Date:          30.9. 2024
 * HUE:           02
 * EX:            03
 * Description:   Do stuff with integer arrays
 * Used Library   JavaUtils (library for common input and array/matrix operations, I have written mostly in first grade)
 *********************************************/

import JavaUtils.*;

public class Main {
    public static final String COMMANDS_MSG = """
                    (0)   Verfügbare Befehle ausgeben
                    (1)   Neu
                    (2)   Füllen mit Zufallszahlen
                    (3)   Einfügen an k.ter Stelle
                    (4)   Löschen der k.Zahl
                    (5)   Löschen der Zahl(en) x
                    (6)   Anhängen
                    (7)   Array um k Stellen vergrößern
                    (8)   Sortieren
                    (9)   Ausgabe
                    (10)  Ende
                    """;

    public static int[] ar = null;

    public static void main(String[] args) {
        System.out.println("EX3\n\n");

        System.out.println("Verfügbare Befehle:");
        System.out.println(COMMANDS_MSG);

        System.out.println("\nAls Erstes muss ein neues Array angelegt werden. Befehl (1) wird automatisch ausgeführt...");
        runCommand(1);

        //noinspection InfiniteLoopStatement
        for (;;) {
            int n = InputUtils.intInput(0, 14, "\nBefehl eingeben: ");
            runCommand(n);
        }
    }

    public static void runCommand(int n) {
        if ((ar == null || ar.length < 1) && n != 1) {
            System.out.println("Es muss zuerst ein Array angelegt werden!");
            return;
        }

        switch (n) {
            case 0: {
                System.out.println(COMMANDS_MSG);
                break;
            }

            case 1: {
                int size = InputUtils.intInput(1, 100000, "Länge des Arrays eingeben: ");
                ar = new int[size];
                break;
            }

            case 2: {
                int lb = InputUtils.intInput(Integer.MIN_VALUE, Integer.MAX_VALUE, "Untere Grenze für Zufallszahlen eingeben: ");
                int ub = InputUtils.intInput(lb, Integer.MAX_VALUE, "Obere Grenze für Zufallszahlen eingeben: ");

                ar = ArrayUtils.randomArray(ar.length, lb, ub);
                break;
            }

            case 3: {
                int value = InputUtils.intInput(Integer.MIN_VALUE, Integer.MAX_VALUE, "Zahl zum Einfügen eingeben: ");
                int index = InputUtils.intInput(0, ar.length, "Index zum Einfügen eingeben: ");

                ar = ArrayUtils.insert(ar, index, value);
                break;
            }

            case 4: {
                int index = InputUtils.intInput(0, ar.length - 1, "Index der zu löschenden Zahl eingeben: ");
                ar = ArrayUtils.delete(ar, index);
                break;
            }

            case 5: {
                int value = InputUtils.intInput(Integer.MIN_VALUE, Integer.MAX_VALUE, "Zahl zum Löschen eingeben: ");
                ar = ArrayUtils.deleteAll(ar, value);
                break;
            }

            case 6: {
                int value = InputUtils.intInput(Integer.MIN_VALUE, Integer.MAX_VALUE, "Zahl zum Anhängen eingeben: ");
                ar = ArrayUtils.append(ar, value);
                break;
            }

            case 7: {
                int k = InputUtils.intInput(1, 100000, "Anzahl der Stellen zum Vergrößern eingeben: ");
                int[] newAr = new int[ar.length + k];
                ArrayUtils.arrayCopy(ar, newAr);
                ar = newAr;
                break;
            }

            case 8: {
                ArrayUtils.sort(ar);
                break;
            }


            case 9: {
                ArrayUtils.printArray(ar);
                break;
            }

            case 10: {
                System.out.println("Programm wird beendet...");
                System.exit(0);
                break;
            }

            default: {
                System.out.println("Ungültige Befehlsnummer!");
            }
        }
    }
}
