/*
 * 
 * Exercise 5.
 * Exercise 6.
 */
package genericsandannotations.generics;

/**
 *
 * @author Cip
 * @param <T>
 */
public class Node<T> implements Comparable<T> {

    /**
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(T t) {
        return 1; // Whatever
    }
    
}

class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }
