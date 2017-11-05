/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectlocks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectLocks {

    private static int count1 = 0;
    private static int count2 = 0;

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void add() {
        synchronized (lock1) {
            count1++;
        }

    }

    public static void addAgain() {
        synchronized (lock2) {
            count2++;
        }

    }

    public static void compute() {
        for (int i = 0; i < 100; ++i) {
            add();
            addAgain();
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
        }

        System.out.println("Count1 = " + count1 + " <-> Count2 = " + count2);
    }

}
