/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency1;

import java.util.logging.Level;
import java.util.logging.Logger;

class Runner1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            try {
                System.out.println("Runner1: " + i);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Runner2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 30; ++i) {
            try {
                System.out.println("Runner2: " + i);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}

public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread t1 = new Runner1();
        Thread t2 = new Runner2();

        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
        }

        System.out.println("Finished the tasks...");
    }

}
