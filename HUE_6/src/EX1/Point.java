package EX1;

public class Point {
    double x, y;
    String color;

    public Point(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.color = null;
    }

    public Point() {
        super();
    }

    @Override
    public String toString() {
        return String.format("%.2f/%.2f %s", x, y, color);
    }

    public boolean equals(Point p) {
        return x == p.x && y == p.y && color.equals(p.color);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calculate distance to another point
     * @param p other point
     * @return distance between this and p
     */
    public double getDistance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    /**
     * Mirror point at the x-axis
     */
    public void mirrorX() {
        this.y = -this.y;
    }

    /**
     * Mirror point at the y-axis
     */
    public void mirrorY() {
        this.x = -this.x;
    }

    /**
     * Move point by dx and dy
     * @param dx delta x
     * @param dy delta y
     */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Scale coordinates
     * @param f factor
     */
    public void scale(double f) {
        this.x *= f;
        this.y *= f;
    }

    /**
     * Scale coordinates
     * @param fx factor x
     * @param fy factor y
     */
    public void scale(double fx, double fy) {
        this.x *= fx;
        this.y *= fy;
    }
}
