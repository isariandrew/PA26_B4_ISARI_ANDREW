package model;

import relationshipService.Relationship;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Person extends Network implements Profile, Comparable<Person> {
    private String name;
    private LocalDate birthDate;
    private String email;
    private Map<Profile, Relationship> relationships = new HashMap<>();

    public Person(String profileId, String name, LocalDate birthDate, String email) {
        super(profileId);
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    @Override
    public String getName() { return name; }

    public LocalDate getBirthDate() { return birthDate; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void addRelationship(Profile profile, Relationship relationship) {
        relationships.put(profile, relationship);
    }

    public Map<Profile, Relationship> getRelationships() {
        return Collections.unmodifiableMap(relationships);
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}