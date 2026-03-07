package relationshipService;

import enums.jobTitle;
import model.Company;
import model.Person;

public class PersonToCompany implements Relationship {
    private Person person;
    private Company company;
    private jobTitle position;

    public PersonToCompany(Person person, Company company, jobTitle position) {
        this.person = person;
        this.company = company;
        this.position = position;
    }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    public jobTitle getPosition() { return position; }
    public void setPosition(jobTitle position) { this.position = position; }

    @Override
    public String getDescription() {
        return "Works at " + company.getName() + " as " + position;
    }
}