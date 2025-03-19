package EX_2;

public class Foil implements Thing {
    private int width, length;
    private String material;
    private double weight;

    public Foil(int width, int length, String material, double weight) {
        this.width = width;
        this.length = length;
        this.material = material;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Foil{" +
                "width=" + width +
                ", length=" + length +
                ", material='" + material + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int getArea() {
        return width * length;
    }

    @Override
    public String getDescriptor() {
        return material;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
