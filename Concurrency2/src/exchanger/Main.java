/*
 * Two Threads can exchange Objects with Exchanger
 *   exchange() method
 */
package exchanger;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

class FirstThread implements Runnable {

    private int counter;
    private Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        while (true) {

            counter++;
            System.out.println("FirstThread incremented the counter: " + counter);

            try {
                counter = exchanger.exchange(counter);

            } catch (InterruptedException e) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class SecondThread implements Runnable {

    private int counter;
    private Exchanger<Integer> exchanger;

    public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        while (true) {

            counter--;
            System.out.println("SecondThread decremented the counter: " + counter);

            try {
                counter = exchanger.exchange(counter);

            } catch (InterruptedException e) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(new FirstThread(exchanger)).start();
        new Thread(new SecondThread(exchanger)).start();

    }

}
