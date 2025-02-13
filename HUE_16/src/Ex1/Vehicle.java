package Ex1;

public class Vehicle implements Comparable<Vehicle> {
    private String manufacturer;
    private String model;

    public Vehicle(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("manufacturer: %s; model: %s; insurancePremium: %.2f", manufacturer, model, getInsurancePremium());
    }

    public double getInsurancePremium() {
        return 200;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @param other Vehicle to compare to
     * @return comparison value
     */
    @Override
    public int compareTo(Vehicle other) {
        int result = 0;
        result += this.manufacturer.compareTo(other.manufacturer);

        if (result == 0) {
            result += this.model.compareTo(other.model);
        }

        if (result == 0) {
            result = Double.compare(this.getInsurancePremium(), other.getInsurancePremium());
        }

        return result;
    }
}
