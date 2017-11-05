/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callableandfuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

class Processor implements Callable<String> {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return ("Id: " + id);
    }

}

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        
        for(int i = 0; i < 5; i++) {
            Future<String> future = executor.submit(new Processor(i+1));
            list.add(future);
        }
        
        for(Future<String> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException ex) {
            } catch (ExecutionException ex) {
            }
        }
        
        
        executor.shutdown();
    }

}
