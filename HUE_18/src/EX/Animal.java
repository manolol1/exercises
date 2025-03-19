package EX;

public abstract class Animal {
    private final int foodPerDay;
    private final String name;
    private final String race;
    private final String sound;
    private final int weight;

    public Animal(int foodPerDay, String name, String race, String sound, int weight) {
        this.foodPerDay = foodPerDay;
        this.name = name;
        this.race = race;
        this.sound = sound;
        this.weight = weight;
    }

    public Animal(int foodPerDay, String name, String race, int weight) {
        this.foodPerDay = foodPerDay;
        this.name = name;
        this.race = race;
        this.sound = "...";
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "foodPerDay=" + foodPerDay +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", sound='" + sound + '\'' +
                ", weight=" + weight +
                '}';
    }

    public abstract boolean wouldEat(Animal animal);

    public String sayHello() {
        return String.format("%s: %s", name, sound);
    }

    public String getSound() {
        return sound;
    }

    public int getFoodPerDay() {
        return foodPerDay;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
