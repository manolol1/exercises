package EX1;

import JavaUtils.JavaUtils;

public class Snail {
    private final String name;
    private int maxSpeed;
    private int distance;

    /**
     * Snail that can participate in a SnailRun
     * @param name Name of the snail
     * @param maxSpeed Maximum distance that the snail can go in one turn
     */
    public Snail(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("{%s, %d, %d}", name, maxSpeed, distance);
    }

    /**
     * Move forward by random distance in range [1;maxSpeed]
     */
    public void creep() {
        this.distance += JavaUtils.random(1, maxSpeed);
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
