package EX;

public class Zoo {
    private final int MAXIMUM_NO_OF_BOXES = 32;
    private AnimalBox[] boxes;
    private int noOfBoxes;

    public Zoo() {
        this.boxes = new AnimalBox[MAXIMUM_NO_OF_BOXES];
    }

    public Animal[] getAllAnimals() {
        int length = 0;
        for (int i = 0; i < noOfBoxes; i++) {
            length += boxes[i].getNoOfAnimals();
        }

        Animal[] result = new Animal[length];
        int resultIndex = 0;

        for (int i = 0; i < noOfBoxes; i++) {
            for (int j = 0; j < boxes[i].getNoOfAnimals(); j++) {
                result[resultIndex] = boxes[i].getAnimals()[j];
                resultIndex++;
            }
        }

        return result;
    }

    public int getDailyFoodAmount() {
        int total = 0;
        for (int i = 0; i < noOfBoxes; i++) {
            total += boxes[i].getDailyFoodAmount();
        }

        return total;
    }

    /**
     * Add an AnimalBox to the Zoo
     * @param animalBox AnimalBox to add
     * @return true if the Animal was added, false if the Box is full
     */
    public boolean addAnimalBox(AnimalBox animalBox) {
        if (noOfBoxes < MAXIMUM_NO_OF_BOXES - 1) {
            boxes[noOfBoxes] = animalBox;
            noOfBoxes++;
            return true;
        }
        return false;
    }
}
