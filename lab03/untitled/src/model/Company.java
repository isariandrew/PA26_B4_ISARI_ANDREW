package model;

public class Company extends Network implements Profile, Comparable<Company>{
    private String name;

    public Company(String profileId, String name) {
        super(profileId);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
}
