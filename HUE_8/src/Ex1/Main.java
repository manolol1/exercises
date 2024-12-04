package Ex1;

public class Main {
    public static void main(String[] args) {
        Fraction a = new Fraction(5, 3);
        Fraction b = new Fraction(10, 15);

        System.out.println(a);
        System.out.println(b);

        Fraction c = a.getCopy();
        c.multiply(b, false);
        System.out.println(c);

        c.reduce();
        System.out.println(c);

        System.out.println();

        Fraction d = new Fraction(5, 2);
        Fraction e = new Fraction(4, 5);

        d.add(e, true);
        System.out.println(d);
        d.subtract(e);
        System.out.println(d);

        System.out.println();

        Fraction f = new Fraction(5, 8);
        Fraction g = new Fraction(3, 2);
        f.divide(g);
        System.out.println(f);
    }
}
