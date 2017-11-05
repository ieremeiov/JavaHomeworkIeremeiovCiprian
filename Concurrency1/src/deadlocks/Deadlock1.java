/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocks;

/**
 *
 * @author Cip
 */
public class Deadlock1 {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Thread1().start(); 
        new Thread2().start();
        
        
        

    }

    private static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread1: Has lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread1: Has lock1 and lock2");
                }
                System.out.println("Thread1: Released lock2");
            }
            System.out.println("Thread1: Released lock1. Exiting...");
        }

    }

    private static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread2: Has lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread2: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread2: Has lock1 and lock2");
                }
                System.out.println("Thread2: Released lock2");
            }
            System.out.println("Thread2: Released lock1. Exiting...");
        }

    }

}
