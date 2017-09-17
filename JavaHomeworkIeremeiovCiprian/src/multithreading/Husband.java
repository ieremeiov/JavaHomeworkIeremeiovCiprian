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

    private String color = ThreadColor.ANSI_BLACK;
    private Wife wife;
    // private Object lock = new Object();
    Thread cleaner = new VacuumCleaner();
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
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
        }

        cleaner.start();

        try {
            cleaner.join();
        } catch (InterruptedException ex) {
        }

        System.out.println(color + "The husband is cleaning the room...");

        while (!show.started()) {
            try {
                System.out.println(color + "Husband is waiting for the show...");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(color + "Husband tries to wake up the wife...");
                show.setStarted(true);
                wife.interrupt();
            }
        }
    }

}
