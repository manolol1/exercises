package TextMode;

import General.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextMode {
    private final Scanner scanner;
    private Board board = null;

    public TextMode() {
        this.scanner = new Scanner(System.in);

        // set up app directory and files
        try {
            FileManager.setup(true);
        } catch (IOException e) {
            System.out.println("An error occurred while setting up the app directory.");
            System.out.println("Creating boards from files might not work!");
            System.out.println("Details: " + e.getMessage());
        }

        System.out.println("\nWelcome to Conway's Game of Life!\n");
        System.out.println(Constants.HELP_MESSAGE);

        System.out.println("New game started. Please create a board!");

        // start board generation process and make sure a board exists
        while (board == null) {
            newBoard();
        }

        System.out.println("\nGreat! The initial board has been created! Now, you can control the game through commands.");
        System.out.println("Enter help or h for a list of commands, in case you forgot.");

        // Game Loop
        //noinspection InfiniteLoopStatement
        for (;;) {
            nextCommand();
        }
    }

    /** Print the board to standard output */
    public void printBoard() {
        boolean[][] alive = board.getMatrix();

        System.out.println("Generation " + board.getGeneration());

        for (boolean[] row : alive) {
            for (boolean col : row) {
                System.out.print((col ? '#' : '-') + " ");
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
            System.out.println("Command could not be parsed. Try again!");
        }

        System.out.println();
        command = command.trim(); // remove whitespace before and after command

        // commands
        switch (command) {
            case "new", "n" -> newBoard();
            case "simulate", "s" -> {
                board.simulate();
                printBoard();
            }
            case "simulate multiple", "sm" -> {
                int count = Utils.intInput(scanner, "Count", 1, 1000);
                board.simulate(count);
                printBoard();
            }
            case "loop", "l" -> {
                //noinspection InfiniteLoopStatement
                for (; ; ) {
                    board.simulate();
                    printBoard();
                    Utils.sleep(500);
                }
            }
            case "loop interval", "li" -> {
                int interval = Utils.intInput(scanner, "Interval in milliseconds", 50, 1_000_000);
                //noinspection InfiniteLoopStatement
                for (; ; ) {
                    board.simulate();
                    printBoard();
                    Utils.sleep(interval);
                }
            }
            case "revive", "r" -> {
                System.out.println("Please enter the coordinates of the cell you want to revive. Coordinates start at 0 and begin in the top left corner.");
                int row = Utils.intInput(scanner, "Row", 0, board.getRows() - 1);
                int col = Utils.intInput(scanner, "Column", 0, board.getColumns() - 1);

                if (!board.getCellStatus(row, col)) {
                    board.revive(row, col);
                    System.out.printf("Revived cell at [%d][%d].\n", row, col);
                    System.out.println("Enter 'print' to view your board or 'simulate' to simulate the next generation and see the results!");
                } else {
                    System.out.println("Cell is already alive. Nothing was done.");
                }
            }
            case "kill", "k" -> {
                System.out.println("Please enter the coordinates of the cell you want to kill. Coordinates start at 0 and begin in the top left corner.");
                int row = Utils.intInput(scanner, "Row", 0, board.getRows() - 1);
                int col = Utils.intInput(scanner, "Column", 0, board.getColumns() - 1);

                if (board.getCellStatus(row, col)) {
                    board.kill(row, col);
                    System.out.printf("Killed cell at [%d][%d].\n", row, col);
                    System.out.println("Enter 'print' to view your board or 'simulate' to simulate the next generation and see the results!");
                } else {
                    System.out.println("Cell is already dead. Nothing was done.");
                }
            }
            case "count", "c" ->
                    System.out.printf("There are currently %d alive cells on the board.\n", board.countAliveCells());
            case "exit", "e" -> {
                System.out.println("Bye!");
                System.exit(0);
            }
            case "print", "p" -> printBoard();
            case "help", "h" -> System.out.println(Constants.HELP_MESSAGE);
            default -> {
                System.out.println("Unknown command. Enter help or h for a list of available commands. Try again!");
                nextCommand();
            }
        }
    }

    /** Command for creating a new board */
    public void newBoard() {
        System.out.printf("""
                Select a board creation mode:
                1 - Random
                2 - Read board from file - files must be stored in %s
                """, Constants.BOARDS_DIRECTORY);

        int mode = Utils.intInput(scanner, "Mode", 1, 2);

        switch(mode) {
            /* random mode */
            case 1:
                // get necessary user input
                int height = Utils.intInput(scanner, "Height", 6, 150);
                int width = Utils.intInput(scanner, "Width", 6, 150);
                int probability = Utils.intInput(scanner, "Probability (%)", 1, 100);

                // generate board
                board = BoardFactory.getRandom(height, width, probability);

                System.out.println("\nA new board has been created!\n");
                printBoard();
                break;
            case 2:
                // read all files to Array
                System.out.println("Reading board files...");
                ArrayList<File> files;
                try {
                    files = FileManager.getBoardFiles();
                } catch (IOException e) {
                    System.out.println("An error occurred while reading the files directory.");
                    System.out.println("Details: " + e);
                    break; //
                }
                System.out.println("Done!\n");

                System.out.println("You can create custom board templates and load them here.");
                System.out.println("The board templates must be stored in the following directory: " + Constants.BOARDS_DIRECTORY);
                System.out.println("You can create as many subdirectories as you like.");
                System.out.println("Some premade boards have already been loaded to the directory.\n");

                System.out.println("Please select one of the available boards:");

                // print available boards
                for (File file : files) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".txt")) {
                        System.out.println(fileName.replaceAll(".txt", ""));
                    }
                }

                // get user selection
                File selectedFile = null;
                while (selectedFile == null) {
                    String selection;
                    try {
                        System.out.print(">> ");
                        selection = scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Input could not be parsed. Try again!");
                        break;
                    }

                    selection += ".txt";
                    selectedFile = Utils.getFileByName(selection, files);

                    if (selectedFile == null) {
                        System.out.println("Board does not exist. Try again!\n");
                    }
                }

                // generate the board
                try {
                    board = BoardFactory.getFromFile(selectedFile);
                } catch (FileNotFoundException e) {
                    System.out.println("The selected board file wasn't found. Maybe, it was deleted?");
                    break;
                } catch(Exception e) {
                    System.out.println("The board couldn't be parsed.");
                    System.out.println("Details: " + e.getMessage());
                    System.out.println("Make sure your board is correctly formatted. For an example, look at the files in the templates directory.\n");
                    break;
                }

                System.out.println("Board created.\n");
                printBoard();

                break;
            default:
                // This case should theoretically never be executed
                System.out.println("Invalid command. Try again!");
                newBoard();
        }
    }
}
