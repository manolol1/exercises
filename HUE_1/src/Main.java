/********************************************
 * Name:          Mario Ebenhofer
 * Date:          11.01. 2024
 * HUE:           01
 * EX:            01
 * Description:   Game of Life
 ********************************************/

import TextMode.TextMode;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            if (args[0].equals("-g")) {
                // TODO: start graphical mode
            } else if (args[0].equals("-t")) {
                new TextMode();
            }
        }
        else if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Headless environment detected. Starting Text Mode.");
            System.out.println("For GUI Mode, run with argument '-g'\n");
            new TextMode();
        } else {
            System.out.println("Graphical environment detected. Starting GUI Mode.");
            System.out.println("For Text Mode, run with argument '-t'\n");
            // TODO: start graphical mode
        }
    }
}