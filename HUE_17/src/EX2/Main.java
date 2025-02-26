package EX2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Employee("", 5345, 5000, 10),
                new Employee(null, 3234, 1500, 1000),
                new Employee("Mario Ebenhofer", 4234, 3500, 15),
                new Employee("Eric Hölzl", 9876, 3200, 20),
                new Employee("Tobias Winkler", 5436, 3500, 15),
                new Worker("William Riegler", 7563, 28, 133.86),
                new Worker("Lukas Hölzl", 8887, 26.5, 102.57),
                new Worker("Florian Palmetshofer", 1743, 27.5, 167.62),
                new Worker("David K.", 9603, 27, 119.54),
                new Worker("Noah Satzinger", 4312, 27, 192.1)
        };

        double[] sum = getCost(people);

        System.out.printf("sumEmployees = %.2f%n", sum[0]);
        System.out.printf("sumWorkers = %.2f%n", sum[1]);
        System.out.println((sum[0] > sum[1] ? "employees" : "workers") + " are more expensive.");

        System.out.println("\nSortiert nach Gruppe und Name:");
        Arrays.sort(people);
        printAll(people);
    }

    /**
     * Calculate the total cost of an array of Persons
     * @param persons Array of Persons
     * @return double[]{sumEmployees, sumWorkers}
     */
    public static double[] getCost(Person[] persons) {
        double sumEmployees = 0;
        double sumWorkers = 0;
        for (Person p : persons) {
            if (p instanceof Employee) {
                sumEmployees += p.computeMoney();
            } else if (p instanceof Worker) {
                sumWorkers += p.computeMoney();
            }
        }

        return new double[]{sumEmployees, sumWorkers};
    }

    public static void printAll(Object[] ar) {
        for (Object obj : ar) {
            System.out.println(obj);
        }
    }
}

