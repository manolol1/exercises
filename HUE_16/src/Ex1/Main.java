package Ex1;

import java.util.ArrayList;
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

        // cheapest bzw. mostExpensive
        System.out.println("\nBillig : ");
        Vehicle cheap;
        cheap= getCheapest(ar);
        if(cheap!=null){
            System.out.println(cheap);; // oder mit toString()
        }else{
            System.out.println("no Vehicle");
        }

        System.out.println("\nTeuer : ");
        Vehicle expensive;
        expensive=getMostExpensive(ar);
        if(expensive!=null){
            System.out.println(expensive.toString()); // oder mit toString()
        }

        // Sortieren nach Kategorie und ausgeben
        System.out.println("\nSortiert : ");
        sortByCategory(ar);
        printAll(ar);

        // Test with null
        Vehicle[] ar2 = new Vehicle[8];
        assert getCheapest(ar2) == null;
        assert getMostExpensive(ar2) == null;
    }

    /**
     * Sort an Array of Vehicles by Category
     * @param vehicles Array of Vehicles
     */
    public static void sortByCategory(Vehicle[] vehicles) {
        if (vehicles == null) {
            return;
        }

        ArrayList<Truck> trucks = new ArrayList<>();
        ArrayList<FluidTruck> fluidTrucks = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Vehicle> other = new ArrayList<>();

        for (Vehicle v : vehicles) {
            if (v == null) {
                continue;
            } else if (v instanceof FluidTruck) {
                fluidTrucks.add((FluidTruck) v);
            } else if (v instanceof Truck) {
                trucks.add((Truck) v);
            } else if (v instanceof Car) {
                cars.add((Car) v);
            } else {
                other.add(v);
            }
        }

        int index = 0;
        System.arraycopy(cars.toArray(new Vehicle[0]), 0, vehicles, index, cars.size());
        index += cars.size();
        System.arraycopy(trucks.toArray(new Vehicle[0]), 0, vehicles, index, trucks.size());
        index += trucks.size();
        System.arraycopy(fluidTrucks.toArray(new Vehicle[0]), 0, vehicles, index, fluidTrucks.size());
        index += fluidTrucks.size();
        System.arraycopy(other.toArray(new Vehicle[0]), 0, vehicles, index, other.size());
    }

    /**
     * Get the Vehicle with the lowest insurance premium in an Array of Vehicles
     * Returns null, if all vehicles are null
     * @param vehicles array of Vehicles
     * @return Vehicle with the cheapest insurance premium
     */
    private static Vehicle getCheapest(Vehicle[] vehicles) {
        if (vehicles == null) {
            return null;
        }

        Vehicle cheapest = vehicles[0];

        for (Vehicle v : vehicles) {
            if (v == null) {
                continue;
            }

            if (cheapest == null) {
                cheapest = v;
                continue;
            }

            if (v.getInsurancePremium() < cheapest.getInsurancePremium()) {
                cheapest = v;
            }
        }

        return cheapest;
    }

    /**
     * Get the Vehicle with the highest insurance premium in an Array of Vehicles
     * Returns null, if any vehicle is null
     * @param vehicles array of Vehicles
     * @return Vehicle with the highest insurance premium
     */
    private static Vehicle getMostExpensive(Vehicle[] vehicles) {
        if (vehicles == null) {
            return null;
        }

        Vehicle mostExpensive = vehicles[0];

        for (Vehicle v : vehicles) {
            if (v == null) {
                continue;
            }

            if (mostExpensive == null) {
                mostExpensive = v;
                continue;
            }

            if (v.getInsurancePremium() > mostExpensive.getInsurancePremium()) {
                mostExpensive = v;
            }
        }

        return mostExpensive;
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

