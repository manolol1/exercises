package EX1;

public class MyTime {
    public static final int SECONDS_PER_DAY = 86400;

    private int hours, minutes, seconds;

    /**
     * Class for storing and processing a time in 24-hour format
     */
    public MyTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        normalize();
    }

    public int getTotalSeconds() {
        return 3600 * hours + 60 * minutes + seconds;
    }

    /**
     * Normalize time (calculate overflows)
     */
    public void normalize() {
        hours = Math.abs(hours);
        minutes = Math.abs(minutes);
        seconds = Math.abs(seconds);
        int totalSeconds = getTotalSeconds() % SECONDS_PER_DAY;

        hours = 0;
        while (totalSeconds >= 3600) {
            hours++;
            totalSeconds -= 3600;
        }

        minutes = 0;
        while (totalSeconds >= 60) {
            minutes++;
            totalSeconds -= 60;
        }

        seconds = totalSeconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
        normalize();
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        normalize();
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
        normalize();
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
