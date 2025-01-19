package EX;

public class LinkedQueue {
    private QueueItem first;
    private QueueItem last;

    public LinkedQueue() {
        first = null;
        last = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        QueueItem current = first;
        while (current != null) {
            sb.append(current.getItem()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    /**
     * Add an item to the queue
     * @param item item to add
     */
    public void enqueue(Object item) {
        QueueItem newItem = new QueueItem(item);
        if (first == null) {
            first = newItem;
            last = newItem;
        } else {
            last.setNext(newItem);
            last = newItem;
        }
    }

    /**
     * Remove the first item from the queue and return it
     * @return first item from the queue
     */
    public Object dequeue() {
        if (first == null) return null;
        Object obj = first.getItem();
        first = first.getNext();
        return obj;
    }

    /**
     * Look at the first Object of the queue
     * @return first Object of the queue
     */
    public Object peek() {
        if (first == null) return null;
        return first.getItem();
    }

    /**
     * Check if the queue is empty
     * @return whether the queue is empty
     */
    public boolean isEmpty() {
        return first == null;
    }
}
