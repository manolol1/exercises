package GraphicsMode;

import General.Board;

import java.awt.*;

public class AutoPlayThread extends Thread{
    private long delay;
    private BoardCanvas canvas;
    private Board board;

    private volatile boolean running = false;
    private final Object pauseLock = new Object();

    public AutoPlayThread(long delay, BoardCanvas canvas, Board board) {
        this.delay = delay;
        this.canvas = canvas;
        this.board = board;
    }

    public void pauseThread() {
        running = false;
    }

    public void resumeThread() {
        synchronized (pauseLock) {
            running = true;
            pauseLock.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            // wait if the thread is paused
            synchronized (pauseLock) {
                while (!running) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            board.simulate();
            canvas.repaint();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setDelay(int autoDelay) {
        this.delay = autoDelay;
    }
}
