package EX_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String s = "Hallo ich bin ein String der geteilt werden soll.";

        System.out.println(Arrays.toString(splitTokenizer(s)));
        System.out.println(Arrays.toString(splitScanner(s)));
        System.out.println(Arrays.toString(splitString(s)));
    }

    public static String[] splitTokenizer(String s) {
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(s);

        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        return tokens.toArray(new String[0]);
    }

    public static String[] splitScanner(String s) {
        ArrayList<String> tokens = new ArrayList<>();
        Scanner scanner = new Scanner(s);

        while (scanner.hasNext()) {
            tokens.add(scanner.next());
        }

        return tokens.toArray(new String[0]);
    }

    public static String[] splitString(String s) {
        return s.split("[^\\p{L}]");
    }
}
