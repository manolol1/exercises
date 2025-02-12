package Ex1;

public class Truck extends Vehicle {
    private int weight;

    public Truck(String manufacturer, String model, int weight) {
        super(manufacturer, model);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("; weight: %d", weight);
    }

    @Override
    public double getInsurancePremium() {
        return 0.7 * weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
