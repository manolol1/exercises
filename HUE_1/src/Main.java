/********************************************
 * Name:          Mario Ebenhofer
 * Date:          11.01. 2024
 * HUE:           01
 * EX:            01
 * Description:   Game of Life
 ********************************************/

import TextMode.TextMode;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            if (args[0].equals("-g")) {
                // TODO: start graphical mode
            } else if (args[0].equals("-t")) {
                new TextMode();
            }
        } else {
            System.out.println("No mode specified. Starting Text Mode.");
            System.out.println("For Graphics Mode, run with argument '-g'\n");
            new TextMode();
        }
    }
}