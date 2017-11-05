/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

/**
 *
 * @author Cip
 */
public class Message {

    private String message;
    private boolean isEmpty = true;

    public synchronized String read() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        isEmpty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        isEmpty = false;
        this.message = message;
        notifyAll();
    }
}
