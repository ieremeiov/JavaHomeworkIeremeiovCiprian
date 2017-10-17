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
public class Tv extends Thread {

    private String color = ThreadColor.ANSI_YELLOW;
    private TvShow show;
    private Husband husband;
    private Wife wife;

    /**
     *
     * @param show the TV Show that is being expected to start at a special
     * moment
     */
    public Tv(TvShow show) {
        this.show = show;
        this.husband = show.getHusband();
        this.wife = show.getWife();
    }

    /**
     * Method that turns on the TV on a separate Thread
     */
    @Override
    public void run() {
        try {
            turnOn();
        } catch (InterruptedException ex) {

        }
    }

    private void turnOn() throws InterruptedException {
        System.out.println(color + "The TV is running...");
        show.start();
        husband.start();
        wife.start();

        husband.join();
        wife.join();
        
        System.out.println(color + "The TV is turned Off!");
    }

}
