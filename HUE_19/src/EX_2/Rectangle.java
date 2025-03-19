package EX_2;

public class Rectangle implements Thing {
    private int width, height;
    private char name;

    public Rectangle(int width, int height, char name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", height=" + height +
                ", name=" + name +
                '}';
    }

    @Override
    public int getArea() {
        return width * height;
    }

    @Override
    public String getDescriptor() {
        return "" + name;
    }
}
