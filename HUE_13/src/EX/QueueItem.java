package EX;

public class QueueItem {
    private Object item;
    private QueueItem next;

    public QueueItem(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public QueueItem getNext() {
        return next;
    }

    public void setNext(QueueItem next) {
        this.next = next;
    }
}
