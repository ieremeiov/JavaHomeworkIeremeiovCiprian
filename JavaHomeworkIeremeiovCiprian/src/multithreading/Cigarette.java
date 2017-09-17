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
public class Cigarette extends Thread {

    private String color = ThreadColor.ANSI_PURPLE;

    /**
     *
     */
    @Override
    public void run() {
        System.out.println(color + "The cigarette is burning and producing ash...");
    }

}
