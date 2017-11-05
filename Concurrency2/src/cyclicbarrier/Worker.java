/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cip
 */
public class Worker implements Runnable {

    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

    public Worker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {

        System.out.println("Thread with id " + id + " starts the task...");

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException ex) {
        }

        System.out.println("Thread with id " + id + " finished...");

        try {
            cyclicBarrier.await();
            System.out.println("After await()...");
        } catch (InterruptedException | BrokenBarrierException ex) {
        }

    }

    @Override
    public String toString() {
        return "" + this.id;
    }

    
}
