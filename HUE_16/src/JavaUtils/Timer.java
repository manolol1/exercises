package JavaUtils;

import java.util.function.Function;

/**
 * Class for measuring time
 */
public class Timer {
    private long start, end;

    /**
     * Resets timer to 0
     */
    public void reset() {
        start = 0;
        end = 0;
    }

    /**
     * Reset timer and start measuring
     */
    public void start() {
        reset();
        start = System.nanoTime();
    }

    /**
     * Stop timer
     */
    public void stop() {
        end = System.nanoTime();
    }

    /**
     * Get time since start
     * @return time since starting the timer in nanoseconds
     */
    public long getNanoseconds() {
        if (end == 0) {
            end = System.nanoTime();
        }

        return end - start;
    }

    /**
     * Get time since start
     * @return time since starting the timer in milliseconds
     */
    public long getMilliseconds() {
        return getNanoseconds() / 1000000;
    }

    /**
     * Measures execution time of a Function
     * @param f Function to test
     * @return execution time of f in nanoseconds
     */
    public static long measureFunctionExecTime(Function f) {
        long start = System.nanoTime();

        f.apply(1);

        return System.nanoTime() - start;
    }

    /**
     * Measures Function execution time multiple times to get an average execution time
     * @param f Function to benchmark
     * @param repetitions How often the Function should be executed
     * @return average execution time in nanoseconds
     */
    public static long benchmarkFunctionExecTime(Function f, int repetitions) {
        long totalTime = 0;

        for (int i = 0; i < repetitions; i++) {
            totalTime += measureFunctionExecTime(f);
        }

        return totalTime / repetitions;
    }

    public static long toMilliseconds(long nanoseconds) {
        return nanoseconds / 1000000;
    }

    public static double toMillisecondsDouble(long nanoseconds) {
        return nanoseconds / 1000000.0;
    }
}
