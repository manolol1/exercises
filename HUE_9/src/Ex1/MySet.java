package Ex1;

import java.util.Arrays;

public class MySet {
    private int[] set;

    public MySet() {
        set = new int[0];
    }

    /**
     * Add a value to the set, if it doesn't already exist
     * @param value will be added to the set
     */
    public void add(int value) {
        if (!contains(value)) {
            int[] newSet = new int[set.length + 1];
            System.arraycopy(set, 0, newSet, 0, set.length);
            newSet[set.length] = value;
            set = newSet;
        }
        sort();
    }

    /**
     * Add another set to the set, if the values don't already exist
     * @param set2 will be added to the set
     */
    public void add(MySet set2) {
        for (int n : set2.getSet()) {
            this.add(n);
        }
    }

    /**
     * Delete a value from the set, if it exists
     * @param value will be deleted from the set
     */
    public void delete(int value) {
        int index = find(value);

        if (index != -1) {
            int[] newSet = new int[set.length - 1];
            // copy values from (old) set into newSet
            int i = 0, j = 0;
            while (j < newSet.length) {
                if (set[i] == value) {
                    // skip deleted value
                    i++;
                }
                newSet[j] = set[i];

                i++;
                j++;
            }

            set = newSet;
        }
    }

    /**
     * Add another set to the set, if the values don't already exist (same as add())
     * @param set2 will be added to the set
     */
    public void union(MySet set2) {
        this.add(set2);
    }

    /**
     * Remove all values from this set, that aren't contained in another
     * @param set2 set to compare to
     */
    public void intersection(MySet set2) {
        for (int value : this.set) {
            if (!set2.contains(value)) {
                this.delete(value);
            }
        }
    }

    /**
     * Check whether the set contains a specific value
     * @param value value to check for
     * @return true, if set contains value; false, if set doesn't contain value
     */
    public boolean contains(int value) {
        return find(value) != -1;
    }

    /**
     * Find a value in the set
     * @return index of the value; -1 if the value doesn't exist
     */
    public int find(int value) {
        for (int i = 0; i < set.length; i++) {
            if (set[i] == value) return i;
        }

        return -1;
    }

    /**
     * Sort the array in ascending order
     */
    public void sort() {
        Arrays.sort(set);
    }

    /**
     * @return total sum of all values in set
     */
    public int getSum() {
        int sum = 0;

        for (int n : set) {
            sum += n;
        }

        return sum;
    }

    public int[] getSet() {
        return set;
    }

    /**
     * Check if set is empty
     * @return whether the set is empty
     */
    public boolean isEmpty() {
        return set.length == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(set).replaceAll("\\[", "{").replaceAll("]", "}");
    }

    public String toStringWithSum() {
        return toString() + " - " + this.getSum();
    }
}
