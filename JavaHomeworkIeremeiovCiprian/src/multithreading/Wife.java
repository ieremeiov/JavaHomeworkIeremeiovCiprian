/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cip
 */
public class Wife extends Thread {

    private String color = ThreadColor.ANSI_BLUE;
    private boolean sleeping = true;

    /**
     * method that models the wife that sleeps until she gets notified by her
     * husband when the Show starts
     */
    @Override
    public void run() {
        sleepUntilShow();
    }

    private void sleepUntilShow() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
        }

        while (sleeping) {
            try {
                System.out.println(color + "The wife is sleeping...");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(color + "The wife woke up...");
                sleeping = false;
            }
        }

    }

}
