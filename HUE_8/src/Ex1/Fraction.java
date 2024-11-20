package Ex1;

public class Fraction {
    private int denominator;
    private int numerator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Fraction(int numerator, int denominator, boolean reduce) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (reduce) reduce();
    }

    /**
     * Multiply with another fraction and reduce
     * @param factor Fraction to multiply with
     */
    public void multiply(Fraction factor) {
        multiply(factor, true);
    }

    /**
     * Multiply with another fraction
     * @param factor Fraction to multiply with
     * @param reduce If true, the Fraction will be reduced
     */
    public void multiply(Fraction factor, boolean reduce) {
        this.denominator *= factor.denominator;
        this.numerator *= factor.numerator;
        if (reduce) reduce();
    }

    public void add(Fraction summand) {
        add(summand, true);
    }

    public void add(Fraction summand, boolean reduce) {

        if (reduce) reduce();
    }

    /**
     * Simplify the fraction, by trying to make its numbers smaller
     */
    public void reduce() {
        int gcd = gcd(denominator, numerator);

        this.denominator /= gcd;
        this.numerator /= gcd;
    }

    /**
     * Find the greatest common divider of n and m
     * @param n first number
     * @param m seconds number
     * @return gcd of n and m
     */
    public static int gcd(int n, int m) {
        n = Math.abs(n);
        m = Math.abs(m);

        int r;

        while (m != 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    /**
     * Find the least common multiple of n
     * @param n first number
     * @param m seconds number
     * @return lcm of n and m
     */
    public static int lcm(int n, int m) {
        n = Math.abs(n);
        m = Math.abs(m);

        return (n * m) / gcd(n, m);
    }

    /**
     * @return copy of this Fraction object
     */
    public Fraction getCopy() {
        return new Fraction(this.numerator, this.denominator);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.numerator, this.denominator);
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
}
