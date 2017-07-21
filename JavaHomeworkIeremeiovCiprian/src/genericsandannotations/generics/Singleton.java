/*
 * Exercise 4.
 */
package genericsandannotations.generics;

// -------------------------------------------------------------------------
public class Singleton<T> {
    
    // parameter T cannot be static. 
    // removed 'static' but it is not appropriate to call it a Singleton anymore
    private T instance = null;
    private final Algorithm outer;
    
    
    @SuppressWarnings("unchecked")
    public T getInstance() {
        if (instance == null) {
            instance = (T) new Singleton<T>(outer);
        }
        return instance;
    }
    

    public Singleton(final Algorithm outer) {
        this.outer = outer;
    }

}
