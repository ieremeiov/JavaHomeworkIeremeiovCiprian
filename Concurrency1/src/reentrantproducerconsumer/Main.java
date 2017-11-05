/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reentrantproducerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import static reentrantproducerconsumer.ThreadColor.*;

/**
 *
 * @author Cip
 */
public class Main {

    public static final String EOF = "EOF";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        
        MyProducer producer = new MyProducer(buffer, ANSI_GREEN, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_RED, bufferLock);
        
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        

    }

}
