package TextMode;

import General.Board;
import General.BoardFactory;

import java.util.Scanner;

public class TextMode {
    public static void start() {
        Scanner s = new Scanner(System.in);

        Board board = BoardFactory.randomBoard(15, 20, 30);
        printBoard(board);
    }

    /** Print the board to standard output */
    public static void printBoard(Board board) {
        boolean[][] alive = board.getMatrix();

        for (int i = 0; i < alive.length; i++) {
            for (int j = 0; j < alive[i].length; j++) {
                System.out.print((alive[i][j] ? '#' : '-') + " ");
            }
            System.out.println();
        }
    }
}
