package EX_1;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2, 5);
        Rectangle r2 = new Rectangle(r1.getLength(), 23);
        Cuboid c1 = new Cuboid(4, 6, 20);
        Cuboid c2 = new Cuboid(r2, 20);
        Pyramid p1 = new Pyramid(r1, 3);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(r2.getArea());
        System.out.println(c2.getBase());
        System.out.println(c2.getArea());
        System.out.println(p1);
        System.out.println(p1.getArea());
        System.out.println(p1.getVolume());
    }
}
