package EX;

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


    }

    /**
     * Create a new Array with ar.length + 1 and copy all values at index 0
     * @param ar Array to expand
     * @return new Array with ar.length + 1
     */
    public static Object[] expandArray(Object[] ar) {
        if (ar == null) return null;
        Object[] newArray = new Object[ar.length + 1];

        for (int i = 0; i < ar.length; i++) {
            newArray[i] = ar[i];
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
