package EX3;

public class Triangle {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Get perimeter of the triangle
     * @return perimeter
     */
    public double getPerimeter() {
        return a.getDistance(b) + b.getDistance(c) + c.getDistance(a);
    }

    /**
     * Get area of the triangle
     * @return area
     */
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a.getDistance(b)) * (s - b.getDistance(c)) * (s - c.getDistance(a)));
    }

    /**
     * Mirror triangle at the x-axis
     */
    public void mirrorX() {
        a.mirrorX();
        b.mirrorX();
        c.mirrorX();
    }

    /**
     * Mirror triangle at the y-axis
     */
    public void mirrorY() {
        a.mirrorY();
        b.mirrorY();
        c.mirrorY();
    }

    /**
     * Move triangle by dx and dy
     * @param dx delta x
     * @param dy delta y
     */
    public void translate(double dx, double dy) {
        a.translate(dx, dy);
        b.translate(dx, dy);
        c.translate(dx, dy);
    }

    /**
     * Get the lower left point of the surrounding rectangle
     * @return lower left point
     */
    public Point lowerLeft() {
        return new Point(Math.min(a.getX(), Math.min(b.getX(), c.getX())), Math.min(a.getY(), Math.min(b.getY(), c.getY())));
    }

    /**
     * Get the upper right point of the surrounding rectangle
     * @return upper right point
     */
    public Point upperRight() {
        return new Point(Math.max(a.getX(), Math.max(b.getX(), c.getX())), Math.max(a.getY(), Math.max(b.getY(), c.getY())));
    }

    /**
     * Check if two triangles are equal
     * @param t other triangle
     * @return true if equal
     */
    public boolean equals(Triangle t) {
        return a.equals(t.a) && b.equals(t.b) && c.equals(t.c);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", a, b, c);
    }


    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }
}
