package EX1;

public class Item {
    private Object value;
    private Item next;

    public Item(Object obj) {
        this.value = obj;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}
