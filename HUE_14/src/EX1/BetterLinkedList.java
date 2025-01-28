package EX1;

/**
 * New improved LinkedList that will certainly replace java.util.LinkedList very soon.
 */
public class BetterLinkedList {
    Item firstItem;
    Item lastItem;
    int size;

    /**
     * Create a new empty BetterLinkedList
     */
    public BetterLinkedList() {
        size = 0;
    }

    /**
     * Convert list to String
     * @return list content as String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Item currItem = firstItem;
        while (currItem != null) {
            sb.append(currItem.getValue()).append(", ");
            currItem = currItem.getNext();
        }


        return sb.substring(0, sb.length() - 2) + "}";
    }

    /**
     * Get the Object at the specified index
     * @param index index of the Object to get
     * @return Object at the specified index
     * @throws IndexOutOfBoundsException when the index is outside the list bounds
     */
    public Object get(int index) throws IndexOutOfBoundsException {
        return getItem(index).getValue();
    }

    /**
     * Get the Item at the specified index
     * @param index index of the Item to get
     * @return Item at the specified index
     * @throws IndexOutOfBoundsException when the index is outside the list bounds
     */
    private Item getItem(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d; Size: %d", index, size));
        }

        Item currItem = firstItem;

        for (int i = 0; i < index; i++) {
            currItem = currItem.getNext();
        }

        return currItem;
    }

    /**
     * Get the last Object of the list
     * @return last Object
     */
    public Object getLast() {
        return lastItem.getValue();
    }

    /**
     * Get the first Object of the list
     * @return first Object
     */
    public Object getFirst() {
        return firstItem.getValue();
    }

    /**
     * Insert an Object at the specified index
     * @param obj Object to insert
     * @param index index to insert at (all indices after the new Object are incremented by 1)
     */
    public void add(Object obj, int index) {
        Item prevItem = this.getItem(index - 1);
        Item newItem = new Item(obj);
        newItem.setNext(prevItem.getNext());
        prevItem.setNext(newItem);
    }

    /**
     * Add an Object at index 0 of the list
     * @param obj Object to add
     */
    public void addFirst(Object obj) {
        size++;
        Item item = new Item(obj);

        if (firstItem == null) {
            firstItem = item;
            lastItem = item;
        } else {
            lastItem.setNext(item);
            lastItem = item;
        }
    }

    /**
     * Add an Object at the last index of the list
     * @param obj Object to add
     */
    public void addLast(Object obj) {
        size++;
        Item item = new Item(obj);

        if (firstItem == null) {
            firstItem = item;
            lastItem = item;
        } else {
            item.setNext(firstItem);
            firstItem = item;
        }
    }

    /**
     * Remove the Object at the specified index
     * @param index index of the Object to remove
     */
    public void remove(int index) {
        Item prevItem = this.getItem(index - 1);
        Item item = prevItem.getNext();
        prevItem.setNext(item.getNext());
        size--;
    }

    /**
     * Remove the first Object of the list
     */

    public void removeFirst() {
        remove(0);
    }

    /**
     * Remove the last Object of the list
     */
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Get the number of Objects in the list
     * @return size of the list
     */
    public int size() {
        return size;
    }
}
