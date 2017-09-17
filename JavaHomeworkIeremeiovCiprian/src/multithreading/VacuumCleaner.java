/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author Cip
 */
public class VacuumCleaner extends Thread {

    private String color = ThreadColor.ANSI_CYAN;

    /**
     *
     */
    @Override
    public void run() {
        System.out.println(color + "The vacuum cleaner is running...");
    }

}
