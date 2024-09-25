package General;

import java.awt.*;
import java.io.File;

public class Constants {
    // files
    public static final File USER_HOME = new File(System.getProperty("user.home"));
    public static final File APP_DIRECTORY = new File(USER_HOME, ".GameOfLife");
    public static final File BOARDS_DIRECTORY = new File(APP_DIRECTORY, "boards");

    public static final String FILE_SETUP_ERROR_MESSAGE = """
            An error occurred while setting up the app directory.
            Creating boards from files might not work!
            Details: """;

    // GUI
    public static final Dimension DEFAULT_MAIN_FRAME_SIZE = new Dimension(1200, 800);

    // CLI
    public static final String HELP_MESSAGE = """
            Available commands:
            new or n - create a new board
            
            simulate or s - simulate the next generation
            simulate multiple or sm - simulate multiple generations

            loop or l - continuously simulate new generations every half second (can only be stopped by ending the program)
            loop interval or li - continuously simulate new generations in the given interval (can only be stopped by ending the program)
            
            revive or r - revive a dead cell
            revive random or rr - revive a random cell
            
            kill or k - kill a cell
            kill random or kr - kill a random cell
            
            count or c - count alive cells
            print or p - print the board
            
            end or e - end the program
            help or h - Show this help message
            """;
}
