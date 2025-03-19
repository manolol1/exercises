package EX;

public class PlantEater extends Animal{

    public PlantEater(int foodPerDay, String name, String race, String sound, int weight) {
        super(foodPerDay, name, race, sound, weight);
    }

    public PlantEater(int foodPerDay, String name, String race, int weight) {
        super(foodPerDay, name, race, weight);
    }

    @Override
    public boolean wouldEat(Animal animal) {
        return false;
    }
}
