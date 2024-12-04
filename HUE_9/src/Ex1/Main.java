package Ex1;

public class Main {
    public static void main(String[] args) {
        MySet s1=new MySet();
        MySet s2=new MySet();

        System.out.println("s1: "+s1); // {}

        s2.add(1);
        s2.add(2);
        s2.add(3);
        s2.add(1);
        System.out.println("s2: "+s2); // {1,2,3}

        s1.add(s2);
        System.out.println("s1: "+s1); // {1,2,3}
        s1.add(5);
        System.out.println("s1: "+s1); // {1,2,3,5}
        s1.delete(5);
        System.out.println("s1: "+s1); // {1,2,3}

        s1.add(5);
        s1.add(8);
        s1.add(3);
        s1.add(5);
        System.out.println("s1: "+s1); // {1,2,3,5,8}
        s1.delete(1);
        s1.delete(2);
        s1.delete(3);
        System.out.println("s1: "+s1); // {5,8}

        s1.union(s2);
        System.out.println("s1: "+s1); // {1,2,3,5,8}

        s2.delete(3);
        s1.intersection(s2);
        System.out.println("s1: "+s1); // {1,2}

        MySet[] sets = new MySet[4];
        sets[0] = new MySet();
        sets[1] = new MySet();
        sets[2] = new MySet();
        sets[3] = new MySet();
        sets[0].add(5);
        sets[0].add(4);
        sets[0].add(-7);
        sets[0].add(12);
        sets[0].add(22);
        sets[0].add(-28);
        sets[1].add(6);
        sets[1].add(12);
        sets[1].add(4);
        sets[1].add(-8);
        sets[1].add(62);
        sets[1].add(8);
        sets[1].add(8);
        sets[2].add(52);
        sets[2].add(3);
        sets[2].add(1);
        sets[2].add(-8);
        sets[2].add(9);
        sets[2].add(6);
        sets[2].add(3);
        sets[3].add(44);
        sets[3].add(23);
        sets[3].add(9);
        sets[3].add(6);
        sets[3].add(12);
        sets[3].add(-30);
        sets[3].add(-17);

        sortSets(sets);
        printSets(sets);
    }

    /**
     * Sort set array by total sums
     * @param ar array to sort
     */
    public static void sortSets(MySet[] ar) {
        int min;
        MySet temp;

        for (int i = 0; i < ar.length; i++) {
            min = i;
            for (int j = i; j < ar.length; j++) {
                if (ar[j].getSum() < ar[min].getSum()) {
                    min = j;
                }
            }

            temp = ar[i];
            ar[i] = ar[min];
            ar[min] = temp;
        }
    }

    /**
     * Print all sets with their sum
     */
    public static void printSets(MySet[] ar) {
        for (MySet set : ar) {
            System.out.println(set.toStringWithSum());
        }
    }
}
