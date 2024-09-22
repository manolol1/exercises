package General;

public class Board {
    private boolean[][] boardMatrix;
    private int generation = 1;

    /** Create a new board object from a 2D-Array
     * @param alive 2D-Array with cells - true = alive, false = dead - use BoardFactory for this.
     */
    public Board(boolean[][] alive) {
        this.boardMatrix = alive;
    }

    /** Simulate the next generation */
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

    /** Simulate multiple generations */
    public void simulate(int count) {
        for (int i = 0; i < count; i++) {
            simulate();
        }
    }

    /** Kill a cell at a specified row and column
     * @param row row in the board, starting at 0
     * @param col column in the board, starting at 0
     */
    public void kill(int row, int col) {
        boardMatrix[row][col] = false;
    }

    /** Revive a cell at a specified row and column
     * @param row row in the board, starting at 0
     * @param col column in the board, starting at 0
     */
    public void revive(int row, int col) {
        boardMatrix[row][col] = true;
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

    /** @return number of alive cells on the board */
    public int countAliveCells() {
        int count = 0;
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
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

    /** return number of rows of the board */
    public int getRows() {
        return boardMatrix.length;
    }

    /** return number of columns of the board */
    public int getColumns() {
        return boardMatrix[0].length;
    }

    /** Get the state of a cell
     * @param row row in the board, starting at 0
     * @param col column in the board, starting at 0
     * @return true = alive, false = dead
     */
    public boolean getCellStatus(int row, int col) {
        return boardMatrix[row][col];
    }
}
