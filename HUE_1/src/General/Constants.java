package General;

public class Constants {
    public static final String HELP_MESSAGE = """
            Available commands:
            new or n - create a new board
            
            simulate or s - simulate the next generation
            simulate --multiple or sm - simulate multiple generations

            continue or c - continuously simulate new generations (can only be stopped by ending the program)
            continue --interval or ci - continuously simulate new generations in the given interval (can only be stopped by ending the program)
            
            revive or r - revive a dead cell
            revive or r --random - revive a random cell
            
            kill or k - kill a cell
            kill or k --random - kill a random cell
            
            print or p - print the board
            end or e - end the program
            help or h - Show this help message
            """;
}
