package Ex2;

import JavaUtils.JavaUtils;

public class Person {
    private String id;
    private String name;
    private int ssn;

    public Person(String name, int ssn) {
        this.name = name == null || name.isEmpty() ? "unknown" : name;
        this.ssn = ssn;
        this.id = "" + Character.toUpperCase(this.name.charAt(0)) + JavaUtils.random(1000, 9999);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ssn=" + ssn +
                '}';
    }

    public double computeMoney() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "unknown" : name;
    }

    public int getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
    }

    public String getId() {
        return id;
    }
}
