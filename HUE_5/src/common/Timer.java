package common;

public class Timer {
    private String title;
    private long startTime;
    private long endTime;

    public Timer() {
        new Timer("Timer");
    }

    public Timer(String title) {
        this.title = title;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        if (startTime == 0) {
            System.out.println("Warning: Timer has not been started yet.");
        }

        endTime = System.nanoTime();
        long result = endTime - startTime;
        System.out.printf("%s: took %d ns (%d ms)", title, result, result / 1000000);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
