/********************************************
 * Name:          Mario Ebenhofer
 * Date:          11.01. 2024
 * HUE:           01
 * EX:            01
 * Description:   Game of Life
 ********************************************/

import GraphicsMode.GraphicsMode;
import TextMode.TextMode;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // determine whether to start in Text or GUI Mode
        if (args.length != 0) {
            if (args[0].equals("-g")) {
                new GraphicsMode();
            } else if (args[0].equals("-t")) {
                new TextMode();
            }
        }
        // no command line argument provided. try to figure out best option
        else if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Headless environment detected. Starting Text Mode.");
            System.out.println("For GUI Mode, run with argument '-g'\n");
            new TextMode();
        } else {
            System.out.println("Graphical environment detected. Starting GUI Mode.");
            System.out.println("For Text Mode, run with argument '-t'\n");
            new GraphicsMode();
        }
    }
}