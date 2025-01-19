package EX;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        System.out.println(stack1);
        System.out.println(stack1.peek());
        stack1.push(34);
        stack1.push(24);
        stack1.push("Hallo");
        stack1.push("Popcorn");
        System.out.println(stack1.toString());
        System.out.println(stack1.pop());
        System.out.println(stack1);

        try {
            while (true) {
                stack1.push(1);
            }
        } catch (StackFullException e) {
            System.out.println("StackFullException occurred -> it works!");
        }

        System.out.println();

        Queue queue1 = new Queue();
        System.out.println(queue1);
        System.out.println(queue1.peek());
        queue1.enqueue(34);
        queue1.enqueue(24);
        queue1.enqueue("Hallo");
        queue1.enqueue("Wort");
        System.out.println(queue1.toString());
        System.out.println(queue1.dequeue());
        System.out.println(queue1);
        queue1.enqueue(new Point(1, 2));
        System.out.println(queue1);

        try {
            while (true) {
                queue1.enqueue(1);
            }
        } catch (QueueFullException e) {
            System.out.println("QueueFullException occurred -> it works!");
        }

        System.out.println();

        LinkedQueue linkedQueue = new LinkedQueue();
        System.out.println(linkedQueue);
        System.out.println(linkedQueue.peek());
        linkedQueue.enqueue(34);
        linkedQueue.enqueue(24);
        linkedQueue.enqueue("Hallo");
        linkedQueue.enqueue("Wort");
        System.out.println(linkedQueue.toString());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue);
        linkedQueue.enqueue(new Point(1, 2));
        System.out.println(linkedQueue);
    }

    /**
     * Create a new Array with ar.length + 1 and copy all values at index 0
     * @param ar Array to expand
     * @return new Array with ar.length + 1
     */
    public static Object[] expandArrayEnd(Object[] ar) {
        if (ar == null) return null;
        Object[] newArray = new Object[ar.length + 1];

        for (int i = 0; i < ar.length; i++) {
            newArray[i] = ar[i];
        }

        return newArray;
    }

    /**
     * Create a new Array with ar.length + 1 and copy all values at index 1
     * @param ar Array to expand
     * @return new Array with ar.length + 1
     */
    public static Object[] expandArrayStart(Object[] ar) {
        if (ar == null) return null;
        Object[] newArray = new Object[ar.length + 1];

        for (int i = 1; i < ar.length + 1; i++) {
            newArray[i] = ar[i - 1];
        }

        return newArray;
    }

    /**
     * Create a new Array with ar.length -1 and copy all elements except for the last one into it.
     * @param ar Array to shrink
     * @return new Array with ar.length -1
     */
    public static Object[] shrinkArray(Object[] ar) {
        if (ar == null) return null;
        Object[] newArray = new Object[ar.length - 1];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = ar[i];
        }

        return newArray;
    }
}
