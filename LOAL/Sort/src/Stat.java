public class Stat {
    private int comparisons;
    private int swaps;
    private int length;
    private String name;

    public Stat(int length, int comparisons, int swaps) {
        this.comparisons = comparisons;
        this.swaps = swaps;
        this.length = length;
    }

    public Stat(int length) {
        this.length = length;
    }

    public Stat(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Stat() {}

    public void compare() {
        comparisons++;
    }

    public void swap() {
        swaps++;
    }

    public void setLength(int n) {
        length = n;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        if (name != null) {
            return String.format("[%s]%nComparisons: %d%nSwaps: %d%nTotal Operations: %d%nn: %d", name, comparisons, swaps, swaps + comparisons, length);
        } else {
            return String.format("Comparisons: %d%nSwaps: %d%nTotal Operations: %d%nn: %d", comparisons, swaps, swaps + comparisons, length);
        }
    }
}
