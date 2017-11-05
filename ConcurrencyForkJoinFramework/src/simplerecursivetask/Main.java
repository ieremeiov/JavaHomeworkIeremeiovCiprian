/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplerecursivetask;

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

        
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        
        ForkJoinPool pool = new ForkJoinPool(numberOfCores);
        SimpleRecursiveTask task = new SimpleRecursiveTask(1000);
        
        int result = pool.invoke(task);
        System.out.println(result);
        
    }
    
}
