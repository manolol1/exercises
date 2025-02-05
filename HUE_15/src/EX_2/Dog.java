package EX_2;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.printf("%s is barking.%n", name);
    }

    public void play() {
        System.out.printf("%s is playing.%n", name);
    }
}
