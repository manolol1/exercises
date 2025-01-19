package EX;

import java.util.Arrays;

public class Stack {
    final int MAX_SIZE = 10000;
    private Object[] items;

    public Stack() {
        items = new Object[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    /**
     * Look at the last Object of the stack
     * @return last Object of the stack
     */
    public Object peek() {
        if (this.isEmpty()) return null;
        return items[items.length - 1];
    }

    /**
     * Push an Object onto the Stack
     * @param obj Object to add
     * @throws StackFullException when the maximum size of the Stack would be exceeded when another item is added.
     */
    public void push(Object obj)  throws StackFullException{
        if (items.length >= MAX_SIZE) {
            throw new StackFullException("The Stack is already full!");
        }

        items = Main.expandArrayEnd(items);
        items[items.length - 1] = obj;
    }

    /**
     * Remove the last item from the Stack and return it
     * @return last item from the Stack
     */
    public Object pop() {
        Object obj = items[items.length - 1];
        items = Main.shrinkArray(items);
        return obj;
    }

    /**
     * Check if the Stack is empty
     * @return whether the Stack is empty
     */
    public boolean isEmpty() {
        return items.length == 0;
    }

    /**
     * Check if the Stack is full
     * @return whether the Stack is full
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
