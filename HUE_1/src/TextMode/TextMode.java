package TextMode;

import General.Board;
import General.BoardFactory;
import General.Constants;
import General.Utils;

import java.util.Scanner;

public class TextMode {
    private final Scanner scanner;
    private Board board = null;

    public TextMode() {
        this.scanner = new Scanner(System.in);

        System.out.println("Welcome to Conway's Game of Life!\n");
        System.out.println(Constants.HELP_MESSAGE);

        System.out.println("New game started. Please create a board!");

        // start board generation process and make sure a board exists
        while (board == null) {
            newBoard();
        }

        System.out.println("\nGreat! The initial board has been created! Now, you can control the game through commands.");
        System.out.println("Enter help or h for a list of commands, in case you forgot.");

        // Game Loop
        for (;;) {
            nextCommand();
        }
    }

    /** Print the board to standard output */
    public void printBoard() {
        boolean[][] alive = board.getMatrix();

        System.out.println("Generation " + board.getGeneration());

        for (int i = 0; i < alive.length; i++) {
            for (int j = 0; j < alive[i].length; j++) {
                System.out.print((alive[i][j] ? '#' : '-') + " ");
            }
            System.out.println();
        }
    }

    /** Prompt user to enter a command and parse it */
    public void nextCommand() {
        String command = "";

        System.out.print("\n>> ");

        try {
            command = scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Command could not be parsed. Try again!");
        }

        System.out.println();
        command = command.trim(); // remove whitespace before and after command

        // commands
        if (command.equals("new") || command.equals("n")) {
            newBoard();
        }
        else if (command.equals("simulate") || command.equals("s")) {
            board.simulate();
            printBoard();
        }
        else if (command.equals("simulate --multiple") || command.equals("sm")) {
            int count = Utils.intInput(scanner, "Count", 1, 1000);
            board.simulate(count);
            printBoard();
        }
        else if (command.equals("exit") || command.equals("e")) {
            System.out.println("Bye!");
            System.exit(0);
        }
        else if (command.equals("print") || command.equals("p")) {
            printBoard();
        }
        else if (command.equals("help") || command.equals("h")) {
            System.out.println(Constants.HELP_MESSAGE);
        }
        else {
            System.out.println("Unknown command. Enter help or h for a list of available commands. Try again!");
            nextCommand();
        }
    }

    /** Command for creating a new board */
    public void newBoard() {
        System.out.println("""
                Select a board creation mode:
                1 - Random
                """);
        // TODO: Add more modes

        //int mode = Utils.intInput(scanner, "Mode", 1, 1);
        int mode = 1; // temporarily skip mode input

        switch(mode) {
            case 1:
                // get necessary user input
                int height = Utils.intInput(scanner, "Height", 6, 150);
                int width = Utils.intInput(scanner, "Width", 6, 150);
                int probability = Utils.intInput(scanner, "Probability (%)", 1, 100);

                // generate board
                board = BoardFactory.randomBoard(height, width, probability);

                System.out.println("\nA new board has been created!");
                printBoard();
                break;
            default:
                // This case should theoretically never be executed
                System.out.println("Invalid command. Try again!");
                newBoard();
        }
    }
}
