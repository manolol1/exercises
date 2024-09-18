package General;

public class Board {
    private boolean[][] boardMatrix;
    private int generation = 1;

    public Board(boolean[][] alive) {
        this.boardMatrix = alive;
    }

    /** Simulates the next generation */
    public void simulate() {
        boolean[][] nextMatrix = new boolean[boardMatrix.length][boardMatrix[0].length];
        generation++;

        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
                int aliveNeighbours = countAliveNeighbours(i, j);

                if ((aliveNeighbours == 3) || (aliveNeighbours == 2 && boardMatrix[i][j])) {
                    nextMatrix[i][j] = true;
                }
            }
        }

        boardMatrix = nextMatrix;
    }

    /** Simulates multiple generations */
    public void simulate(int count) {
        for (int i = 0; i < count; i++) {
            simulate();
        }
    }

    /** Count alive cells next to a specified cell in the matrix */
    public int countAliveNeighbours(int row, int col) {
        int count = 0;

        for (int i = row - 1; i < row + 2; i++) {
            if (i < 0 || i > boardMatrix.length - 1) continue; // stay inside bounds

            for (int j = col - 1; j < col + 2; j++) {
                if (j < 0 || j > boardMatrix[0].length - 1) continue; // stay inside bounds
                if (i ==  row && j == col) continue; // exclude the element itself

                if (boardMatrix[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    /** @return 2D-Array that stores alive and dead cells (true = alive; false = dead) */
    public boolean[][] getMatrix() {
        return boardMatrix;
    }

    /** @return generation number */
    public int getGeneration() {
        return generation;
    }
}
