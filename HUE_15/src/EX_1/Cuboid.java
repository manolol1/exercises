package EX_1;

public class Cuboid extends Rectangle {
    private int height;

    public Cuboid() {}

    public Cuboid(int length, int width, int height) {
        super(length, width);
        this.height = height;
    }

    public Cuboid(Rectangle rectangle, int height) {
        super(rectangle);
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Cuboid{length: %d, width: %d, height: %d}", super.getLength(), super.getWidth(), height);
    }

    public int getVolume() {
        return getBase() * getHeight();
    }

    public int getBase() {
        return super.getArea();
    }

    public int getArea() {
        return 2 * getBase() + getCircumference() * height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
