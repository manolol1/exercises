package EX;

public class MeatEater extends Animal {

    public MeatEater(int foodPerDay, String name, String race, String sound, int weight) {
        super(foodPerDay, name, race, sound, weight);
    }

    public MeatEater(int foodPerDay, String name, String race, int weight) {
        super(foodPerDay, name, race, weight);
    }

    @Override
    public boolean wouldEat(Animal animal) {
        return animal instanceof MeatEater && animal.getWeight() < this.getWeight();
    }
}
