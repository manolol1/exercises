package EX3;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(6, 2);
        Point c = new Point(3, 12);
        Triangle t = new Triangle(a, b, c);
        System.out.println(t.getPerimeter());
        System.out.println(t.getArea());
        t.mirrorX();
        System.out.println(t.getPerimeter());
        System.out.println(t.getArea());
        t.mirrorY();
        System.out.println(t.getPerimeter());
        System.out.println(t.getArea());
        t.translate(1, 1);
        System.out.println(t.getPerimeter());
        System.out.println(t.getArea());
    }
}
