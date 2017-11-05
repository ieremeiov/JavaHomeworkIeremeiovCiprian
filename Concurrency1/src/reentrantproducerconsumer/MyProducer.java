/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reentrantproducerconsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Cip
 */
public class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferlock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferlock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {

            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted...");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");

        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }

}
