import enums.jobTitle;
import model.*;
import relationshipService.PersonToCompany;
import relationshipService.PersonToPerson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // --- Persons ---
        Programmer alice = new Programmer("p1", "Alice",   LocalDate.of(1995, 3, 12),  "alice@mail.com",   "Java");
        Designer   bob   = new Designer  ("p2", "Bob",     LocalDate.of(1992, 7, 24),  "bob@mail.com",     "https://bobdesigns.io");
        Person   charlie = new Person    ("p3", "Charlie", LocalDate.of(1988, 11, 5),  "charlie@mail.com");

        // --- Companies ---
        Company acme = new Company("c1", "Acme Corp", "Software");
        Company beta = new Company("c2", "Beta Ltd",  "Design");

        // --- Relationships ---
        PersonToPerson aliceKnowsBob     = new PersonToPerson(alice, bob,     "Colleagues from university");
        PersonToPerson bobKnowsCharlie   = new PersonToPerson(bob,   charlie, "Met at a conference");

        PersonToCompany aliceAtAcme   = new PersonToCompany(alice,   acme, jobTitle.Programmer);
        PersonToCompany charlieAtAcme = new PersonToCompany(charlie, acme, jobTitle.Designer);
        PersonToCompany bobAtBeta     = new PersonToCompany(bob,     beta, jobTitle.Designer);

        // --- Populate maps ---
        alice.addRelationship(bob,     aliceKnowsBob);
        alice.addRelationship(acme,    aliceAtAcme);

        bob.addRelationship(charlie,   bobKnowsCharlie);
        bob.addRelationship(beta,      bobAtBeta);

        charlie.addRelationship(acme,  charlieAtAcme);

        // --- Mixed sorted list ---
        List<Profile> network = new ArrayList<>();
        network.add(alice);
        network.add(bob);
        network.add(charlie);
        network.add(acme);
        network.add(beta);

        network.sort(Comparator.comparing(Profile::getName));

        System.out.println("=== Network (sorted by name) ===");
        for (Profile p : network) {
            System.out.println(p.getName() + " [" + p.getProfileId() + "]");
        }

        System.out.println("\n=== Relationships per Person ===");
        for (Person person : List.of(alice, bob, charlie)) {
            System.out.println(person.getName() + ":");
            for (Map.Entry<Profile, relationshipService.Relationship> entry : person.getRelationships().entrySet()) {
                System.out.println("  " + entry.getValue().getDescription());
            }
        }
    }
}