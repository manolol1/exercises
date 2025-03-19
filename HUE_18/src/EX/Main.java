package EX;

public class Main {
    public static void main (String[]args){
        Zoo zoo = new Zoo();
        AnimalBox dangerousBox = new AnimalBox("Dangerous box");
        zoo.addAnimalBox(dangerousBox);
        Animal crocodile = new MeatEater(1000, "Croco", "Crocodile", "schnapp", 3000);
        dangerousBox.addAnimal(crocodile);
        Animal tiger = new MeatEater(2000, "Toni", "Tiger", "roaarrr", 8000);
        dangerousBox.addAnimal(tiger);
        Animal sheep = new PlantEater(500, "Cindy", "Sheep", "bääääh", 800);
        dangerousBox.addAnimal(sheep);
        System.out.println(dangerousBox.sayHello());
        System.out.println();
        AnimalBox pinkBox = new AnimalBox("Pink box");
        zoo.addAnimalBox(pinkBox);
        pinkBox.addAnimal(sheep);
        System.out.println(pinkBox.sayHello());
        System.out.println();
        pinkBox.addAnimal(tiger);
        Animal rhino = new PlantEater(5000, "Albert", "Rhinoceros", 15800);
        dangerousBox.addAnimal(rhino);
        System.out.println(dangerousBox.sayHello());
        System.out.println();
        System.out.println("We are hungry! give us " + zoo.getDailyFoodAmount() +
                " g of food every day!");
        System.out.println();
        Animal[] animals = zoo.getAllAnimals();
        System.out.println("All animals in the zoo (unsorted): ");
        print(animals);
        System.out.println();
        System.out.println("All animals in the zoo (sorted by name): ");
        sortByName(animals);
        print(animals);
        System.out.println();
        System.out.println("All animals in the zoo (sorted by category): ");
        sortByCategory(animals);
        print(animals);
    }

    public static void print(Object[] ar) {
        for (Object obj : ar) {
            System.out.println(obj);
        }
    }

    public static void sortByName(Animal[] ar) {
        int minIndex;
        Animal temp;

        for (int i = 0; i < ar.length; i++) {
            minIndex = i;
            for (int j = i; j < ar.length; j++) {
                if (ar[j].getName().compareTo(ar[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }
            temp = ar[minIndex];
            ar[minIndex] = ar[i];
            ar[i] = temp;
        }
    }

    public static void sortByCategory(Animal[] ar) {
        int minIndex;
        Animal temp;

        for (int i = 0; i < ar.length; i++) {
            minIndex = i;
            for (int j = i; j < ar.length; j++) {
                if (ar[j].getClass().getSimpleName().compareTo(ar[minIndex].getClass().getSimpleName()) < 0) {
                    minIndex = j;
                }
            }
            temp = ar[minIndex];
            ar[minIndex] = ar[i];
            ar[i] = temp;
        }
    }
}
