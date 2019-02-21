/**
 * CarlStack.java
 * Jeff Ondich, 31 January 2019
 *
 * An example stack interface to help illustrate
 * the difference between interfaces and
 * implementations.
 */

public interface CarlStack<T> {
    public void push(T data);
    public T peek();
    public T pop();
    public int size();
    public boolean isEmpty();

    public static void main(String[] args) {
    	System.out.println("Hello World");
    }
}