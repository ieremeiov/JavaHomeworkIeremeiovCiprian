/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executorproducerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import static reentrantproducerconsumer.ThreadColor.*;

/**
 *
 * @author Cip
 */
public class Main {

    public static final String EOF = "EOF";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_RED);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(500);
                System.out.println(ThreadColor.ANSI_BLUE + "I'm being printed from the Callable class.");
                Thread.sleep(500);
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong.");
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }

        executorService.shutdown();

    }

}
