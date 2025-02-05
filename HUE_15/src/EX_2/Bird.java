package EX_2;

public class Bird extends Animal{
    public Bird() {
    }

    public Bird(String name) {
        super(name);
    }

    public void chirp() {
        System.out.printf("%s is chirping.%n", name);
    }

    public void fly() {
        System.out.printf("%s is flying.%n", name);
    }
}
