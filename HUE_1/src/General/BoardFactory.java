package General;

public class BoardFactory {
    /** Generate a new board with random values */
    public static Board randomBoard(int height, int width, int probabilityPercent) {
        boolean[][] alive = new boolean[height][width];

        for (int i = 0; i < alive.length; i++) {
            for (int j = 0; j < alive[i].length; j++) {
                alive[i][j] = ((int) (Math.random() * 100)) <= probabilityPercent;
            }
        }

        return new Board(alive);
    }
}
