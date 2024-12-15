// Point class from HUE_6 (modified)
package EX3;

public class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        super();
    }

    @Override
    public String toString() {
        return String.format("%.2f/%.2f", x, y);
    }

    /**
     * Get a new point that's moved by dx and dy
     * @param dx movement on the x-axis
     * @param dy movement on the y-axis
     * @return new moved Point
     */
    public Point moved(double dx, double dy) {
        return new Point(x + dx, y + dy);
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

    public boolean equals(Point p) {
        return x == p.x && y == p.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
