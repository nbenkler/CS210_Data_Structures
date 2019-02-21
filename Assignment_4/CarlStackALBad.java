/**
 * CarlStackALBad.java
 * Jeff Ondich, 31 January 2019
 *
 * An example stack implementation to help illustrate
 * the relationship between interfaces and implementations.
 * This implementation makes poor use of an ArrayList.
 * What's wrong with it?
 */
import java.util.ArrayList;

public class CarlStackALBad<T> implements CarlStack<T> {
    private ArrayList<T> list;

    public CarlStackALBad() {
        this.list = new ArrayList<T>();
    }

    public CarlStackALBad(int initialCapacity) {
        this.list = new ArrayList<T>(initialCapacity);
    }

    public void push(T data) {
        this.list.add(0, data);
    }

    public T peek() {
        return this.list.get(0);
    }

    public T pop() {
        T topItem = this.list.get(0);
        this.list.remove(0);
        return topItem;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}