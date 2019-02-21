/**
 * CarlStackAL.java
 * Noam Benkler, 31 January 2019
 *
 * An example stack implementation to help illustrate
 * the relationship between interfaces and
 * implementations.
 */
import java.util.ArrayList;

public class CarlStackAL<T> implements CarlStack<T> {
    private ArrayList<T> list;

    public CarlStackAL() {
        this.list = new ArrayList<T>();
    }

    public CarlStackAL(int initialCapacity) {
        this.list = new ArrayList<T>(initialCapacity);
    }

    public void push(T data) {
        this.list.add(data);
    }

    public T peek() { //throws EmptyStackException {
        return this.list.get(this.list.size() - 1);
    }

    public T pop() {
        T topItem = this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return topItem;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}

