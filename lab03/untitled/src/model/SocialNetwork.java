package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocialNetwork {
    private List<Profile> profiles = new ArrayList<>();

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public boolean removeProfile(Profile profile) {
        return profiles.remove(profile);
    }

    public List<Profile> getProfiles() {
        return Collections.unmodifiableList(profiles);
    }

    public List<Profile> getSortedProfiles() {
        List<Profile> sorted = new ArrayList<>(profiles);
        sorted.sort(Comparator.comparing(Profile::getName));
        return sorted;
    }

    public List<Profile> getProfilesByImportance() {
        List<Profile> sorted = new ArrayList<>(profiles);
        sorted.sort(Comparator.comparingInt(Profile::getImportance).reversed());
        return sorted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Social Network ===\n");

        for (Profile p : getProfilesByImportance()) {
            sb.append(String.format("%n[Importance: %d] %s (ID: %s)",
                    p.getImportance(), p.getName(), p.getProfileId()));

            if (p instanceof Person person) {
                sb.append(String.format(" | Born: %s | Email: %s",
                        person.getBirthDate(), person.getEmail()));

                if (person instanceof Programmer programmer) {
                    sb.append(String.format(" | Language: %s", programmer.getPrimaryLanguage()));
                } else if (person instanceof Designer designer) {
                    sb.append(String.format(" | Portfolio: %s", designer.getPortfolioUrl()));
                }

                if (!person.getRelationships().isEmpty()) {
                    sb.append("\n  Relationships:");
                    for (var entry : person.getRelationships().entrySet()) {
                        sb.append("\n    -> ").append(entry.getValue().getDescription());
                    }
                }
            } else if (p instanceof Company company) {
                sb.append(String.format(" | Industry: %s", company.getIndustry()));
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}