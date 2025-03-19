package demo;

import java.util.Calendar;

public class Vehicle implements Age {
    private String model;
    private int year;

    public Vehicle(String name, int year) {
        this.year = year;
        this.model = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - year;
    }
}
