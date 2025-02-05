package EX_1;

public class Pyramid extends Rectangle {
    private int height;

    public Pyramid() {}

    public Pyramid(int length, int width, int height) {
        super(length, width);
        this.height = height;
    }

    public Pyramid(Rectangle rectangle, int height) {
        super(rectangle);
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Pyramid{length: %d, width: %d, height: %d}", super.getLength(), super.getWidth(), height);
    }

    public int getBase() {
        return super.getArea();
    }

    public int getVolume() {
        return getBase() * getHeight() / 3;
    }

    public int getArea() {
        return -1; // it's complicated...
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
