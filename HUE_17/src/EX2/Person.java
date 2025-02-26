package EX2;

import JavaUtils.JavaUtils;

public abstract class Person implements Comparable<Person>{
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

    @Override
    public int compareTo(Person p) {
        int result = 0;
        result += this.getClass().getSimpleName().compareTo(p.getClass().getSimpleName());

        if (result == 0) {
            result += this.getName().compareTo(p.getName());
        }


        return result;
    }

    public abstract double computeMoney();

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
