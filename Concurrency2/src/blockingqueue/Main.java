/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

class FirstWorker implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public FirstWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        int counter = 0;

        while (true) {
            try {
                blockingQueue.put(counter);
                System.out.println("Putting items to the queue... " + counter);
                counter++;
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class SecondWorker implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int number = blockingQueue.take();
                System.out.println("Taking items from the queue..." + number);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        
        FirstWorker first = new FirstWorker(queue);
        SecondWorker second = new SecondWorker(queue);
        
        new Thread(first).start();
        new Thread(second).start();
        
        
        

    }

}
