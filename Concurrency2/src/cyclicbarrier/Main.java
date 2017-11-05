/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Cip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            
            @Override
            public void run() {
                System.out.println("All the tasks are finished...so we can now use the results...");
            }
        });

        for(int i = 0; i < 5; i++) {
            executorService.execute(new Worker(i+1, barrier));
        }
        
        executorService.shutdown();
        
    }
    
}
