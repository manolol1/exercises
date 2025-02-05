package EX_2;

public class Animal {
    protected String name;

    public Animal() {}

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.printf("%s is eating.%n", name);
    }

    public void sleep() {
        System.out.printf("%s is sleeping.%n", name);
    }
}
