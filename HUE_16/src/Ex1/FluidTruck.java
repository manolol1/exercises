package Ex1;

public class FluidTruck extends Truck {
    private int dangerLevel;

    public FluidTruck(String manufacturer, String model, int weight, int dangerLevel) {
        super(manufacturer, model, weight);
        this.dangerLevel = dangerLevel;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("; dangerLevel: %d", dangerLevel);
    }

    @Override
    public double getInsurancePremium() {
        return 0.7 * getWeight() * dangerLevel;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }
}
