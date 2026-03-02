package relationshipService;

import model.Person;

public class PersonToPerson {
    private Person firstPerson;
    private Person secondPerson;
    private String contextOfRelationship;

    public PersonToPerson(Person firstPerson, Person secondPerson, String contextOfRelationship) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
        this.contextOfRelationship = contextOfRelationship;
    }

    public Person getFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(Person firstPerson) {
        this.firstPerson = firstPerson;
    }

    public Person getSecondPerson() {
        return secondPerson;
    }

    public void setSecondPerson(Person secondPerson) {
        this.secondPerson = secondPerson;
    }

    public String getContextOfRelationship() {
        return contextOfRelationship;
    }

    public void setContextOfRelationship(String contextOfRelationship) {
        this.contextOfRelationship = contextOfRelationship;
    }
}
