/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static threads.ThreadColor.ANSI_GREEN;
import static threads.ThreadColor.ANSI_PURPLE;
import static threads.ThreadColor.ANSI_RED;

/**
 *
 * @author Cip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the annonymous class thread.");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the annonymous class's implementation of run");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }

            }
        });
        myRunnableThread.start();
        //       anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");

    }

}
