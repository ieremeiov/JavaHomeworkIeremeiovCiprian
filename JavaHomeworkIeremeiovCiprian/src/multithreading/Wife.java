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

    private String color = ThreadColor.ANSI_PURPLE;
    private boolean sleeping = true;
    private Husband husband;
    TvShow show;

    /**
     * method that models the wife that sleeps until she gets notified by her
     * husband when the Show starts
     */
    @Override
    public void run() {
        sleepUntilShow();
    }

    private synchronized void sleepUntilShow() {
        
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
                System.out.println(color + "Wife is watching the show.");

                try {
                    wait();
                } catch (InterruptedException ex1) {
                    System.out.println(color + "Wife stopped watching the show.");
                }

            }
        }

    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

}
