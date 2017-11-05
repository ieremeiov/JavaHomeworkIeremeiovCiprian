/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fairlocks;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Cip
 */
public class FairLocks {

    private static ReentrantLock lock = new ReentrantLock(true);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Piority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Piority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Piority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Piority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Piority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    private static class Worker implements Runnable {

        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount);
                    runCount++;
                    // execute critical section of code  
                } finally {
                    lock.unlock();
                }
            }
        }

    }

}
