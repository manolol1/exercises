package EX_2;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    public void meow() {
        System.out.printf("%s is meowing.%n", name);
    }

    public void purr() {
        System.out.printf("%s is purring.%n", name);
    }
}
