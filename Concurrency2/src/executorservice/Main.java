/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       // ExecutorService executorService = Executors.newFixedThreadPool(3);
       // ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        for(int i = 0; i < 5; i++) {
            executorService.submit(new Worker());
        }
        
        executorService.shutdown();
        
    }
}



class Worker implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
