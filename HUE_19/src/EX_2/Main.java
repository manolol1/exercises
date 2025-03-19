package EX_2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Thing[] ar = {
                new Foil(20, 10, "Aluminium", 0.5),
                new Rectangle(16, 15, 'b'),
                new Foil(30, 10, "Gold", 2.5),
                new Rectangle(15, 16, 'a'),
                new Foil(10, 10, "Copper", 1.2),
        };

        print(ar);
        sortDescriptor(ar);
        print(ar);
        sortArea(ar);
        print(ar);
        sortAreaDescriptor(ar);
        print(ar);
        sortDescriptorArea(ar);
        print(ar);
    }

    public static void print(Object[] ar) {
        for (Object o : ar) {
            System.out.println(o);
        }
        System.out.println();
    }

    public static void sortDescriptor(Thing[] ar) {
        Arrays.sort(ar, Comparator.comparing(Thing::getDescriptor));
    }

    public static void sortArea(Thing[] ar) {
        Arrays.sort(ar, Comparator.comparing(Thing::getArea));
    }

    public static void sortAreaDescriptor(Thing[] ar) {
        Arrays.sort(ar, Comparator.comparing(Thing::getArea).thenComparing(Thing::getDescriptor));
    }

    public static void sortDescriptorArea(Thing[] ar) {
        Arrays.sort(ar, Comparator.comparing(Thing::getDescriptor).thenComparing(Thing::getArea));
    }
}
