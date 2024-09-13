public class Main {
    public static void main(String[] args) {
        final String HELP_MESSAGE = """
                Usage:
                    pwdgen <length> <mode> - Generate a password with the specified length and mode.
                    pwdgen <length> all - Generate passwords with the specified length and all available modes.
                    pwdgen help - Display this help message.
                
                Modes:
                    ...
                """;

        switch(args.length) {
            case 1:
                if (args[0].equalsIgnoreCase("help")) {
                    System.out.println(HELP_MESSAGE);
                }
            case 2:
                break;
            default:
                System.out.println("Missing arguments.\n");
                System.out.println(HELP_MESSAGE);
        }
    }
}