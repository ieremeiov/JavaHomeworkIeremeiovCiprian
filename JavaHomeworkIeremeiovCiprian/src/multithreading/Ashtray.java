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
public class Ashtray extends Thread {

    private String color = ThreadColor.ANSI_GREEN;

    /**
     *
     */
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
        }
        System.out.println(color + "The ashtray is receiving more and more ash...");
    }

}
