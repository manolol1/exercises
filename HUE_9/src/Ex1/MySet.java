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
    }

    /**
     * Delete a value from the set, if it exists
     * @param value will be deleted from the set
     */
    public void delete(int value) {
        if (contains(value)) {
            int[] newSet = new int[set.length - 1];
            int index = find(value);
            System.arraycopy(set, 0, newSet, 0, index - 1);
            System.arraycopy(set, index, newSet, index, newSet.length);
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

    @Override
    public String toString() {
        return Arrays.toString(set).replaceAll("\\[", "{").replaceAll("]", "}");
    }
}
