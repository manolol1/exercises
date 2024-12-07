package Ex2;

public class Interval {
    private int lowerBound, upperBound;
    private boolean empty;

    /**
     * Interval
     * @param lowerBound inclusive lower bound
     * @param upperBound inclusive upper bound
     */
    public Interval(int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) {
            this.empty = true;
        } else {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    /**
     * Empty Interval
     */
    public Interval() {
        this.empty = true;
    }

    @Override
    public String toString() {
        return this.empty ? "[]" : String.format("[%d,%d]", lowerBound, upperBound);
    }

    /**
     * Check if the interval contains a number
     * @param n number to check
     * @return whether the interval contains n (false if interval is empty)
     */
    public boolean contains(int n) {
        if (empty) return false;

        return n >= lowerBound && n <= upperBound;
    }

    /**
     * Check if the interval contains another interval
     * @param i other interval
     * @return whether the interval contains i
     */
    public boolean contains(Interval i) {
        if (i == null) return true; // null is seen as an empty interval
        if (this.isEmpty()) return i.isEmpty();
        if (i.isEmpty()) return true;

        return i.lowerBound >= this.lowerBound && i.upperBound <= this.upperBound;
    }

    /**
     * Check if two intervals are equal
     * @param i interval to compare to
     * @return whether both intervals have exactly the same properties
     */
    public boolean equals(Interval i) {
        if (i == null) return false;
        return this.isEmpty() == i.isEmpty() && this.lowerBound == i.lowerBound && this.upperBound == i.upperBound;
    }

    /**
     * Check if there is no intersection with another interval
     * @param i other interval
     * @return whether this.intersection(i) is empty
     */
    public boolean disjoint(Interval i) {
        return this.intersection(i).isEmpty();
    }

    /**
     * Find intersection with another interval
     * @param i other interval
     * @return intersection or empty Interval, if there is no intersection
     */
    public Interval intersection(Interval i) {
        if (i == null || this.empty || i.empty) return new Interval();
        return new Interval(Math.max(this.lowerBound, i.lowerBound), Math.min(this.upperBound, i.upperBound));
    }

    /**
     * Get hull around this and another interval
     * @param i other interval
     * @return hull
     */
    public Interval hull(Interval i) {
        if (i.isEmpty()) return this.getCopy();
        return new Interval(Math.min(this.lowerBound, i.lowerBound), Math.max(this.upperBound, i.upperBound));
    }

    /**
     * @return Amount of values that the interval contains
     */
    public int getLength() {
        return Math.abs(this.lowerBound - this.upperBound);
    }

    /**
     * Get a new Object with the same properties as this
     * @return new Interval with same properties as this one
     */
    public Interval getCopy() {
        return new Interval(this.lowerBound, this.upperBound);
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public boolean isEmpty() {
        return empty;
    }
}
