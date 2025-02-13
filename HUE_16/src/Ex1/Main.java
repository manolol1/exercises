package Ex1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vehicle[] ar = new Vehicle[8];
        ar[0]=new Car("Skoda","Oktavia",90);
        ar[1]=new Truck("Volva","Truck",8000);
        ar[2]=new Car("Skoda","Fabia",70);
        ar[3]=new FluidTruck("Man","Dangertruck",7500,2);
        ar[4]=new Truck("Mercedes","Monstertruck",7000);
        ar[5]=new Car("Skoda","Oktavia",120);
        ar[6]=new Truck("Man","Truck",9000);
        ar[7]=new Car("Skoda","Oktavia",75);

        // Ausgabe unsortiert
        System.out.println("Unsortiert : ");
        printAll(ar);

        // Sortieren und ausgeben
        System.out.println("\nSortiert : ");
        sort(ar);
        printAll(ar);
//
//        // cheapest bzw. mostExpensive
//        System.out.println("\nBillig : ");
//        Vehicle cheap;
//        cheap=getcheapest(ar);
//        if(cheap!=null){
//            cheap.print(); // oder mit toString()
//        }else{
//            System.out.println("no Vehicle");
//        }
//
//        System.out.println("\nTeuer : ");
//        Truck expensive;
//        expensive=getMostExpensiv(ar);
//        if(expensive!=null){
//            expensive.print(); // oder mit toString()
//        }….
//
//        // Sortieren nach Kategorie und ausgeben
//        System.out.println("\nSortiert : ");
//        sortByCategory(ar);
//        printAll(ar);

    }

    /**
     * Print an Array of Objects
     * @param ar Array of Objects
     */
    private static void printAll(Object[] ar) {
        for (Object obj : ar) {
            System.out.println(obj);
        }
    }

    /**
     * Sort an Array of Vehicles using the Object's compareTo method
     * @param vehicles Array of Vehicles
     */
    private static void sort(Vehicle[] vehicles) {
        Arrays.sort(vehicles);
    }
}

