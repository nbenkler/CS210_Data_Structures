/**
 * CarlStackLL.java
 * Jeff Ondich, 31 January 2019
 *
 * An example stack implementation to help illustrate
 * the relationship between interfaces and implementations.
 */
import java.util.LinkedList;
//import java.util.EmptyStackException;

public class CarlStackLL<T> implements CarlStack<T> {
    private LinkedList<T> list;

    public CarlStackLL() {
        this.list = new LinkedList<T>();
    }

    public void push(T data) {
        this.list.add(0, data);
    }

    public T peek() { //throws EmptyStackException {
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