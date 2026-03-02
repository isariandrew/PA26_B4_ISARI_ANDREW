package model;

public class Person extends Network implements Profile, Comparable<Person>{
    private final String name;

    public Person(String profileId, String name) {
        super(profileId);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
