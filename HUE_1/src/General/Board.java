package General;

public class Board {
    boolean[][] alive;

    public Board(boolean[][] alive) {
        this.alive = alive;
    }

    /** Simulates the next generation */
    public void simulate() {

    }

    /** Simulates multiple generations */
    public void simulate(int count) {
        for (int i = 0; i < count; i++) {
            simulate();
        }
    }

    /** @return 2D-Array that stores alive and dead cells (true = alive; false = dead) */
    public boolean[][] getMatrix() {
        return alive;
    }
}
