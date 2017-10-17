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
    private int startTimer = 1;
    private int showDuration = 2;

    private Husband husband;
    private Wife wife;

    private volatile boolean started = false;
    private volatile boolean ended = false;

    private int countStart = 0;
    private int countEnd = 0;

    /**
     *
     * @param husband the Husband that is going to notice the TV Show when it
     * starts
     * @param wife
     */
    public TvShow(Husband husband) {
        this.husband = husband;
        this.wife = husband.getWife();
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
        wife.show = this;

        while (!started) {

            System.out.println(color + "The TV Show didn't start yet...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }

            if (countStart == startTimer) {
                break;
            }
            countStart++;
        }

        synchronized (this) {
            System.out.println(color + "The Show has started !!!");
            started = true;
            husband.interrupt();
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
        }
        
        synchronized (this) {
        
            while (!ended) {

                System.out.println(color + "The TV Show is running.");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }

                if (countEnd == showDuration) {
                    ended = true;
                }

                countEnd++;

            }

            System.out.println(color + "The Show has ended !!!");
            husband.interrupt();
            wife.interrupt();
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
     * @return
     */
    public Wife getWife() {
        return wife;
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
