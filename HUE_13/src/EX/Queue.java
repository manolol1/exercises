package EX;

public class Queue {
    final int MAX_SIZE = 10000;
    private Object[] items;

    public Queue() {
        items = new Object[0];
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(items);
    }

    /**
     * Add an item to the queue
     * @param item item to add
     */
    public void enqueue(Object item) {
        if (items.length >= MAX_SIZE) {
            throw new QueueFullException("The Queue is already full!");
        }

        items = Main.expandArrayStart(items);
        items[0] = item;
    }

    /**
     * Remove the last item from the queue and return it
     * @return last item from the queue
     */
    public Object dequeue() {
        Object obj = items[items.length - 1];
        items = Main.shrinkArray(items);
        return obj;
    }

    /**
     * Look at the first Object of the queue
     * @return first Object of the queue
     */
    public Object peek() {
        if (this.isEmpty()) return null;
        return items[0];
    }

    /**
     * Check if the queue is empty
     * @return whether the queue is empty
     */
    public boolean isEmpty() {
        return items.length == 0;
    }

    /**
     * Check if the queue is full
     * @return whether the queue is full
     */
    public boolean isFull() {
        return items.length >= MAX_SIZE;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public Object[] getItems() {
        return items;
    }
}
