import enums.jobTitle;
import model.Company;
import model.Person;
import model.Profile;
import relationshipService.PersonToCompany;
import relationshipService.PersonToPerson;

void main() {

    // --- Persons and Companies ---
    Person alice = new Person("p1", "Alice");
    Person bob = new Person("p2", "Bob");
    Person charlie = new Person("p3", "Charlie");

    Company acme = new Company("c1", "Acme Corp");
    Company beta = new Company("c2", "Beta Ltd");

    // --- Person-to-Person relationships ---
    PersonToPerson rel1 = new PersonToPerson(alice, bob, "Colleagues from university");
    PersonToPerson rel2 = new PersonToPerson(bob, charlie, "Met at a conference");

    // --- Person-to-Company relationships ---
    PersonToCompany emp1 = new PersonToCompany(alice, acme, jobTitle.Programmer);
    PersonToCompany emp2 = new PersonToCompany(charlie, acme, jobTitle.Designer);
    PersonToCompany emp3 = new PersonToCompany(bob, beta, jobTitle.Programmer);

    // --- Mixed list sorted by name via Comparator ---
    List<Profile> network = new ArrayList<>();
    network.add(alice);
    network.add(bob);
    network.add(charlie);
    network.add(acme);
    network.add(beta);

    network.sort(Comparator.comparing(Profile::getName));

    IO.println("=== Network (sorted by name) ===");
    for (Profile p : network) {
        IO.println(p.getName() + " [" + p.getProfileId() + "]");
    }

    IO.println("\n=== Person-to-Person Relationships ===");
    for (PersonToPerson rel : List.of(rel1, rel2)) {
        IO.println(rel.getFirstPerson().getName()
                + " knows " + rel.getSecondPerson().getName()
                + " -> " + rel.getContextOfRelationship());
    }

    IO.println("\n=== Person-to-Company Relationships ===");
    for (PersonToCompany emp : List.of(emp1, emp2, emp3)) {
        IO.println(emp.getPerson().getName()
                + " works at " + emp.getCompany().getName()
                + " as " + emp.getPosition());
    }
}