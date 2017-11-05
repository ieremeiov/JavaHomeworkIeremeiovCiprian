/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reentrantproducerconsumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import static reentrantproducerconsumer.Main.EOF;

/**
 *
 * @author Cip
 */
public class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {

        int counter = 0;

        while (true) {

            if (bufferLock.tryLock()) {

                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The 'fail to lock' counter = " + counter);
                    counter = 0;
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
            
        }

    }

}
