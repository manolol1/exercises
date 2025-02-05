package EX_2;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Rex");
        dog.eat();
        dog.bark();
        dog.play();
        dog.sleep();

        Cat cat = new Cat("Garfield");
        cat.eat();
        cat.meow();
        cat.purr();
        cat.sleep();

        Bird bird = new Bird("Tweety");
        bird.eat();
        bird.chirp();
        bird.fly();
        bird.sleep();
    }
}
