package EX_1;

public class Rectangle {
    private int length, width;

    public Rectangle() {};

    public Rectangle(Rectangle rectangle) {
        this.length = rectangle.length;
        this.width = rectangle.width;
    };

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format("Rectangle{length: %d, width: %d}", length, width);
    }

    /**
     * Calculate the Area of the Rectangle
     * @return Area (length * width)
     */
    public int getArea() {
        return length * width;
    }

    /**
     * Calculate the Circumference of the Rectangle
     * @return Circumference ((length * width) * 2)
     */
    public int getCircumference() {
        return (width + length) * 2;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
