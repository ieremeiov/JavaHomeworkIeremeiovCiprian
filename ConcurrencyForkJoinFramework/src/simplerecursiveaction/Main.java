/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplerecursiveaction;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Cip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // assign the number of Processors
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        
        ForkJoinPool pool = new ForkJoinPool(availableProcessors);
        SimpleRecursiveAction recursiveAction = new SimpleRecursiveAction(1000);
        
        pool.invoke(recursiveAction);
        
    }
    
}
