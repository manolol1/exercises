package Ex2;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("", 5345, 5000, 10),
                new Employee(null, 3234, 1500, 1000),
                new Employee("Mario Ebenhofer", 4234, 3500, 15),
                new Employee("Eric Hölzl", 9876, 3200, 20),
                new Employee("Tobias Winkler", 5436, 3500, 15)
        };

        Worker[] workers = {
                new Worker("William Riegler", 7563, 28, 133.86),
                new Worker("Lukas Hölzl", 8887, 26.5, 102.57),
                new Worker("Florian Palmetshofer", 1743, 27.5, 167.62),
                new Worker("David K.", 9603, 27, 119.54),
                new Worker("Noah Satzinger", 4312, 27, 192.1)
        };

        double sumEmployees = getCost(employees);
        double sumWorkers = getCost(workers);

        System.out.printf("sumEmployees = %.2f%n", sumEmployees);
        System.out.printf("sumWorkers = %.2f%n", sumWorkers);
        System.out.println((sumEmployees > sumWorkers ? "employees" : "workers") + " are more expensive.");
    }

    /**
     * Calculate the total cost of an array of Persons
     * @param persons Array of Persons
     * @return sum of cost
     */
    public static double getCost(Person[] persons) {
        double sum = 0;
        for (Person p : persons) {
            sum += p.computeMoney();
        }

        return sum;
    }
}

