package General;

import java.io.File;

public class BoardFactory {
    /** Generate a new board with random values */
    public static Board getRandom(int height, int width, int probabilityPercent) {
        boolean[][] alive = new boolean[height][width];

        for (int i = 0; i < alive.length; i++) {
            for (int j = 0; j < alive[i].length; j++) {
                alive[i][j] = ((int) (Math.random() * 100)) <= probabilityPercent;
            }
        }

        return new Board(alive);
    }

    /** Generate a new board from a file */
    public static Board getFromFile(File file) throws Exception {
        String[] lines = Utils.fileToStringArray(file);

        // remove spaces
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replaceAll(" ", "");
        }

        // make sure that all lines have the same length
        int columns = lines[0].length();
        for (String line : lines) {
            if (line.length() != columns) {
                throw new Exception("Invalid board: The board must be rectangle-shaped. Make sure that alle lines have the same length!");
            }
        }

        boolean[][] alive = new boolean[lines.length][columns];

        // read board and fill alive[]
        for (int i = 0; i < alive.length; i++) {
            for (int j = 0; j < alive[0].length; j++) {
                char ch = lines[i].charAt(j);
                if (ch == '0') {
                    alive[i][j] = false;
                } else if (ch == '1') {
                    alive[i][j] = true;
                } else {
                    throw new Exception("Invalid character. Only use 0, 1 and spaces!");
                }
            }
        }

        return new Board(alive);
    }
}
