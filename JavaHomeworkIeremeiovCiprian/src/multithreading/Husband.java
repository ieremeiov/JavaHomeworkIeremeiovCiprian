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
public class Husband extends Thread {

    private String color = ThreadColor.ANSI_BLUE;
    private Wife wife;
    // private Object lock = new Object();
    private Thread cleaner = new VacuumCleaner();
    TvShow show;

    /**
     *
     * @param wife
     */
    public Husband(Wife wife) {
        this.wife = wife;
    }

    /**
     * method that models in a separate Thread the husband that cleans the room
     * before the show and when the Show starts he tries to wake up his wife
     */
    @Override
    public void run() {
        cleanAndWaitForShow();
    }

    private void cleanAndWaitForShow() {

        // wife accepts the ring :D
        wife.setHusband(this);

        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
        }

        cleaner.start();

        System.out.println(color + "The husband is cleaning the room...");

        while (!show.started()) {

            try {

                System.out.println(color + "Husband is waiting for the show...");
                Thread.sleep(1000);

            } catch (InterruptedException ex) {

                System.out.println(color + "Husband tries to wake up the wife...");
                show.setStarted(true);
                cleaner.interrupt();
                wife.interrupt();

                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex1) {
                }

                
                System.out.println(color + "Husband is watching the show.");

                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException ex1) {
                        System.out.println(color + "Husband stopped watchign the show.");
                    }
                }
            }
        }
    }

    public Wife getWife() {
        return this.wife;
    }

}
