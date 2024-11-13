package EX1;

import java.time.ZonedDateTime;

/**
 * Class for storing and processing a time in 24-hour format
 */
public class MyTime {
    private int hours, minutes, seconds;

    public MyTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        normalize();
    }

    public MyTime(int totalSeconds) {
        this.seconds = totalSeconds;
        // minutes and hours will be automatically calculated by normalize()
        normalize();
    }

    public int getTotalSeconds() {
        return 3600 * hours + 60 * minutes + seconds;
    }

    /**
     * Normalize time (calculate overflows and account for negative values)
     */
    public void normalize() {
        // seconds
        if (seconds >= 60 || seconds < 0) {
            minutes += seconds / 60;
            seconds = seconds % 60;
            if (seconds < 0) {
                seconds += 60;
                minutes--;
            }
        }

        //  minutes
        if (minutes >= 60 || minutes < 0) {
            hours += minutes / 60;
            minutes = minutes % 60;
            if (minutes < 0) {
                minutes += 60;
                hours--;
            }
        }

        // hours
        if (hours >= 24 || hours < 0) {
            hours = hours % 24;
            if (hours < 0) {
                hours += 24;
            }
        }
    }

    /**
     * Add a time to this time.
     * @param t2 Time to add
     */
    public void add(MyTime t2) {
        // prevent NullPointerException
        if (t2 == null) {
            t2 = new MyTime(0, 0, 0);
        }

        hours += t2.hours;
        minutes += t2.minutes;
        seconds += t2.seconds;
        normalize();
    }

    /**
     * Subtract a time from this time.
     * @param t2 Time to add
     */
    public void subtract(MyTime t2) {
        // prevent NullPointerException
        if (t2 == null) {
            t2 = new MyTime(0, 0, 0);
        }

        hours -= t2.hours;
        minutes -= t2.minutes;
        seconds -= t2.seconds;
        normalize();
    }

    /**
     * Calculate the difference of two times
     * @param t1 first time
     * @param t2 seconds time
     * @return Difference
     */
    public static MyTime difference(MyTime t1, MyTime t2) {
        return new MyTime(Math.abs(t1.getTotalSeconds() - t2.getTotalSeconds()));
    }

    /**
     * Convert MyTime to String
     * @return MyTime as String in hh:mm:ss format
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /**
     * Make a deep copy of this MyTime
     * @return copy
     */
    public MyTime getCopy() {
        return new MyTime(hours, minutes, seconds);
    }

    /**
     * Get current time (in the correct timezone)
     * @return current time
     */
    public static MyTime now() {
        ZonedDateTime currentTime = ZonedDateTime.now();
        return new MyTime(currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
    }

    /**
     * Convert MyTime to String
     * @param withSeconds if enabled, the total seconds will be added next to the formatted time.(hh:mm:ss  --  totalSeconds)
     * @return MyTime as String in hh:mm:ss format.
     */
    public String toString(boolean withSeconds) {
        if (withSeconds) {
            return String.format("%02d:%02d:%02d  --  Total Seconds: %d", hours, minutes, seconds, getTotalSeconds());
        } else {
            return toString();
        }
    }

    public String getGreeting() {
        if (hours <= 5 || hours >= 21) {
            return "Good night";
        } else if (hours <= 10) {
            return "Good morning";
        } else if (hours <= 13) {
            return "Good noon";
        } else if (hours <= 16) {
            return "Good afternoon";
        } else {
            return "Good night";
        }
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
}
