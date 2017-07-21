/*
 * Exercise 2.
 * There were some extra ';' in the code that I had to delete. Most probably a typing error. 
 */
package genericsandannotations.generics;

/**
 *
 * @author Cip
 */

// Pair<K, V> becomes Pair
// K, V get (down)casted to Object


public class Pair {
    
    private Object key;
    private Object value;

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey()   { return key; }
    public Object getValue() { return value; }

    public void setKey(Object key)     { this.key = key; }
    public void setValue(Object value) { this.value = value; }

    
}
