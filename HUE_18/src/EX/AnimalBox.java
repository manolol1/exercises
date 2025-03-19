package EX;

public class AnimalBox {
    private final int MAXIMUM_NO_OF_ANIMALS = 16;
    private String name;
    private Animal[] animals;
    private int noOfAnimals = 0;

    public AnimalBox(String name) {
        this.name = name;
        animals = new Animal[MAXIMUM_NO_OF_ANIMALS];
    }

    public String sayHello() {
        StringBuilder message = new StringBuilder();
        message.append(this.name).append(":");
        for (int i = 0; i < noOfAnimals; i++) {
            message.append(" ").append(animals[i].getSound());
        }

        return message.toString();
    }

    public int getDailyFoodAmount() {
        int total = 0;
        for (int i = 0; i < noOfAnimals; i++) {
            total += animals[i].getFoodPerDay();
        }

        return total;
    }

    /**
     * Add an Animal to the AnimalBox
     * @param a Animal to add
     * @return true if the Animal was added, false if the Box is full or the Animal would be eaten
     */
    public boolean addAnimal(Animal a) {
        if (noOfAnimals < MAXIMUM_NO_OF_ANIMALS - 1) {
            for (int i = 0; i < noOfAnimals; i++) {
                if (animals[i].wouldEat(a)) {
                    return false;
                }
            }

            animals[noOfAnimals] = a;
            noOfAnimals++;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public int getNoOfAnimals() {
        return noOfAnimals;
    }
}

