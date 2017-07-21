/*
 * Exercise 1.
 * Exercise 3.
 */
package genericsandannotations.generics;

import java.util.List;

/**
 *
 * @author Cip
 */
public final class Algorithm {

    // We need a way to Compare T types with each other. '>' can be used with primitive types. 
    // For other Classes we need to implement Comparable and override compareTo() method 
    public static <T> T max(T x, T y) {
        //      return x > y ? x : y;
        return null;
    }

// -------------------------------------------------------------------------
    // It seems that there is no problem with compiling this method.
    public static void print(List<? extends Number> list) {
        for (Number n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    

    
}
