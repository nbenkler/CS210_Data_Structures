/**
 * BinarySearchableCollection.java
 * Noam Benkler, 18 February 2019
 *
 * Implementation of our SearchableCollection interface,
 * for use in our exploration of search algorithms.
 */

import java.util.ArrayList;
import java.util.*;

public class BinarySearchableCollection<KeyType extends Comparable<KeyType>, ValueType>
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

    public BinarySearchableCollection() {
        this.list = new ArrayList<KeyValuePair>();
    }

    public int size() {
        return this.list.size();
    }

    public void add(KeyType key, ValueType value) {
        KeyValuePair pair = new KeyValuePair(key, value);
        int N = this.size();
        int i = 0;
        if (N==0){
            this.list.add(pair);
        }
        else{
            this.list.add(null);
            while(N-i-1 >= 0 && (key.compareTo(this.list.get(N-1-i).key) <= 0)){
                this.list.set(N-i,this.list.get(N-1-i));
                i++;
            }
        }
        this.list.set(N-i, pair);
    }

    public boolean containsKey(KeyType searchKey) {
        return this.find(searchKey) != null;
    }


    public ValueType find(KeyType searchKey) {
        int N = this.size();
        int low = 0;
        int high = N;
        int mid = high/2;
        KeyValuePair currentItem = this.list.get(mid);

        while (low<=high)  {
            if (currentItem.key == searchKey) {
                return currentItem.value;
            }else if (currentItem.key.compareTo(searchKey) == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (high+low)/2;
            currentItem = this.list.get(mid);
        }
        return null;
    }

    public static void main(String[] args) {
        // Two simple tests of our BinarySearchableCollection implementation.

        // 1. Test BinarySearchableCollection on a collection of Strings
        BinarySearchableCollection<String, Integer> stringCollection = new BinarySearchableCollection<String, Integer>();
        stringCollection.add("goat", 4);
        stringCollection.add("civet", 5);
        stringCollection.add("ocelot", 6);
        stringCollection.add("capybara", 8);
        stringCollection.add("elk", 3);
        stringCollection.add("jaguar", 9);

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

        // 2. Test BinarySearchableCollection on a collection of Persons
        BinarySearchableCollection<String, Person> personCollection = new BinarySearchableCollection<String, Person>();
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
