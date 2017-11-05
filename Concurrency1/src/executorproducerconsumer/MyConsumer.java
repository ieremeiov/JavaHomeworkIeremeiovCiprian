/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executorproducerconsumer;

import reentrantproducerconsumer.*;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import static reentrantproducerconsumer.Main.EOF;

/**
 *
 * @author Cip
 */
public class MyConsumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        while (true) {
            
            synchronized (buffer) {
                try {

                    if (buffer.isEmpty()) {
                        continue;
                    }
                    // can throw NullPointerException if not synchronized
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }

        }

    }

}
