package Ex1;

public class Car extends Vehicle {
    private int horsePower;

    public Car(String manufacturer, String model, int horsePower) {
        super(manufacturer, model);
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("; horsePower: %d", horsePower);
    }

    @Override
    public double getInsurancePremium() {
        return 200 + 7 * horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
