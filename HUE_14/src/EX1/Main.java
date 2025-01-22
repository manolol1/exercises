package EX1;


public class Main {
    public static void main(String[] args) {
        BetterLinkedList myList = new BetterLinkedList();

        myList.addFirst("Hallo");
        myList.addFirst("Ich bin ein String");
        myList.addFirst(45);
        myList.addLast(1);
        myList.addFirst(9);
        myList.addLast(3);

        System.out.println(myList.toString());
        System.out.println(myList.get(2));
        myList.add("insert", 3);
        System.out.println(myList.toString());
        System.out.println(myList.getLast());

    }
}
