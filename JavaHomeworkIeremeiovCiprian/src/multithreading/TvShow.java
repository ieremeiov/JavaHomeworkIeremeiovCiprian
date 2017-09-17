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
public class TvShow extends Thread {

    private String color = ThreadColor.ANSI_RED;
    private int timer = 1;

    private Husband husband;

    private volatile boolean started = false;
    private int count = 0;

    /**
     *
     * @param husband the Husband that is going to notice the TV Show when it
     * starts
     * @param wife
     */
    public TvShow(Husband husband) {
        this.husband = husband;

    }

    /**
     * Method that models in a separate Thread what happens on the TV relative
     * to the special TV Show (if the show started or not)
     */
    @Override
    public void run() {
        isTheShowStartedYet();
    }

    private void isTheShowStartedYet() {
        husband.show = this;

        while (!started) {
            System.out.println(color + "The TV Show didn't start yet...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }

            if (count == timer) {
                break;
            }
            count++;
        }

        synchronized (this) {
            System.out.println(color + "The Show has started !!!");
            started = true;
            husband.interrupt();
        }
    }

    /**
     *
     * @return
     */
    public Husband getHusband() {
        return husband;
    }

    /**
     *
     * @return if the TV Show has started
     */
    public boolean started() {
        return started;
    }

    /**
     *
     * @param started set true if the TV Show has started, else set to false
     */
    public void setStarted(boolean started) {
        this.started = started;
    }

}
