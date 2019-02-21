/**
 * Person.java
 * Jeff Ondich, 13 February 2019
 *
 * A simple class to help us explore various search algorithms.
 * This object supports comparison to a String search key, where
 * the comparison is between the search key and the Person object's
 * family name.
 */

public class Person implements Comparable<Person> {
    private String givenName;
    private String familyName;
    private int birthYear;

    public Person(String givenName, String familyName, int birthYear) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.birthYear = birthYear;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getFullName() {
        return this.givenName + " " + this.familyName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    // The Comparable<Person> interface.
    public int compareTo(Person other) {
        int comparison = this.familyName.compareTo(other.familyName);
        if (comparison != 0) {
            return comparison;
        }

        comparison = this.givenName.compareTo(other.givenName);
        if (comparison != 0) {
            return comparison;
        }

        return this.birthYear - other.birthYear;
    }
}
