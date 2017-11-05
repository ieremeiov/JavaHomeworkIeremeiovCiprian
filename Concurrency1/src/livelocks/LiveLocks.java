/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelocks;

/**
 *
 * @author Cip
 */
public class LiveLocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final Worker worker1 = new Worker("Worker1", true);
        final Worker worker2 = new Worker("Worker2", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();

    }

}
