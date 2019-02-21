/**
 * LinearSearchableCollection.java
 * Jeff Ondich, 13 February 2019
 *
 * Example implementation of our SearchableCollection interface,
 * for use in our exploration of search algorithms.
 */

import java.util.ArrayList;

public class LinearSearchableCollection<KeyType extends Comparable<KeyType>, ValueType>
        implements SearchableCollection<KeyType, ValueType> {

    private ArrayList<KeyValuePair> list;

    private class KeyValuePair {
        public KeyType key;
        public ValueType value;

        public KeyValuePair(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
        }
    }

    public LinearSearchableCollection() {
        this.list = new ArrayList<KeyValuePair>();
    }

    public int size() {
        return this.list.size();
    }

    public void add(KeyType key, ValueType value) {
        KeyValuePair pair = new KeyValuePair(key, value);
        this.list.add(pair);
    }

    public boolean containsKey(KeyType searchKey) {
        return this.find(searchKey) != null;
    }

    public ValueType find(KeyType searchKey) {
        int N = this.size();
        for (int k = 0; k < N; k++) {
            KeyValuePair currentItem = this.list.get(k);
            if (currentItem.key.compareTo(searchKey) == 0) {
                return currentItem.value;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Two simple tests of our LinearSearchableCollection implementation.

        // 1. Test LinearSearchableCollection on a collection of Strings
        LinearSearchableCollection<String, Integer> stringCollection = new LinearSearchableCollection<String, Integer>();
        stringCollection.add("goat", 4);
        stringCollection.add("civet", 5);
        stringCollection.add("ocelot", 6);
        stringCollection.add("capybara", 8);
        stringCollection.add("elk", 3);

        String searchKey = "civet";
        if (stringCollection.containsKey(searchKey)) {
            System.out.println("Yay! Found " + searchKey);
        } else {
            System.out.println("Boo! Did not find " + searchKey);
        }

        searchKey = "cthulhu";
        if (stringCollection.containsKey(searchKey)) {
            System.out.println("Boo! Found " + searchKey);
        } else {
            System.out.println("Yay! Did not find " + searchKey);
        }

        // 2. Test LinearSearchableCollection on a collection of Persons
        LinearSearchableCollection<String, Person> personCollection = new LinearSearchableCollection<String, Person>();
        Person p = new Person("Isaac", "Newton", 1642);
        personCollection.add(p.getFamilyName(), p);
        p = new Person("Ada", "Lovelace", 1815);
        personCollection.add(p.getFamilyName(), p);
        p = new Person("Johnny", "von Neumann", 1903);
        personCollection.add(p.getFamilyName(), p);
        p = new Person("Jean", "Bartik", 1924);
        personCollection.add(p.getFamilyName(), p);

        searchKey = "Bartik";
        Person person = personCollection.find(searchKey);
        if (person != null) {
            System.out.println("Yay! Found " + person.getFullName());
        } else {
            System.out.println("Boo! Did not find " + searchKey);
        }

        searchKey = "Turing";
        person = personCollection.find(searchKey);
        if (person != null) {
            System.out.println("Boo! Found " + person.getFullName());
        } else {
            System.out.println("Yay! Did not find " + searchKey);
        }
    }
}