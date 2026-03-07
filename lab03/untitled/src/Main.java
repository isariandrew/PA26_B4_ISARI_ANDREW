import enums.jobTitle;
import model.*;
import relationshipService.PersonToCompany;
import relationshipService.PersonToPerson;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // --- Persons ---
        Programmer alice   = new Programmer("p1", "Alice",   LocalDate.of(1995, 3, 12), "alice@mail.com",  "Java");
        Designer   bob     = new Designer  ("p2", "Bob",     LocalDate.of(1992, 7, 24), "bob@mail.com",    "https://bobdesigns.io");
        Person     charlie = new Person    ("p3", "Charlie", LocalDate.of(1988, 11, 5), "charlie@mail.com");

        // --- Companies ---
        Company acme = new Company("c1", "Acme Corp", "Software");
        Company beta = new Company("c2", "Beta Ltd",  "Design");

        // --- Relationships ---
        PersonToPerson  aliceKnowsBob   = new PersonToPerson (alice,   bob,     "Colleagues from university");
        PersonToPerson  bobKnowsCharlie = new PersonToPerson (bob,     charlie, "Met at a conference");
        PersonToCompany aliceAtAcme     = new PersonToCompany(alice,   acme,    jobTitle.Programmer);
        PersonToCompany charlieAtAcme   = new PersonToCompany(charlie, acme,    jobTitle.Designer);
        PersonToCompany bobAtBeta       = new PersonToCompany(bob,     beta,    jobTitle.Designer);

        // --- Populate maps ---
        alice.addRelationship(bob,  aliceKnowsBob);
        alice.addRelationship(acme, aliceAtAcme);
        bob.addRelationship(charlie, bobKnowsCharlie);
        bob.addRelationship(beta,    bobAtBeta);
        charlie.addRelationship(acme, charlieAtAcme);

        // --- Build and print network ---
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.addProfile(alice);
        socialNetwork.addProfile(bob);
        socialNetwork.addProfile(charlie);
        socialNetwork.addProfile(acme);
        socialNetwork.addProfile(beta);

        System.out.println(socialNetwork);
    }
}