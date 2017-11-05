/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker implements Runnable {

    // private BlockingQueue<String> blockingQueue;
    private BlockingQueue<Person> blockingQueue;

    public FirstWorker(BlockingQueue<Person> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            // will be put in alphabetical order
//            blockingQueue.put("B");
//            blockingQueue.put("H");
//            blockingQueue.put("F");
//            Thread.sleep(1000);
//            blockingQueue.put("A");
//            Thread.sleep(1000);
//            blockingQueue.put("E");

//            blockingQueue.put(10);
//            blockingQueue.put(2);
//            blockingQueue.put(4);
//            Thread.sleep(1000);
//            blockingQueue.put(0);
//            Thread.sleep(1000);
//            blockingQueue.put(21);

            blockingQueue.put(new Person(12, "Adam"));
            blockingQueue.put(new Person(45, "Joe"));
            blockingQueue.put(new Person(78, "Daniel"));
            Thread.sleep(1000);
            blockingQueue.put(new Person(32, "Noel"));
            Thread.sleep(1000);
            blockingQueue.put(new Person(34, "Kevin"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class SecondWorker implements Runnable {

    // private BlockingQueue<String> blockingQueue;
    private BlockingQueue<Person> blockingQueue;

    public SecondWorker(BlockingQueue<Person> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // BlockingQueue<String> queue = new PriorityBlockingQueue<>();
        // BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        BlockingQueue<Person> queue = new PriorityBlockingQueue<>();

        new Thread(new FirstWorker(queue)).start();
        new Thread(new SecondWorker(queue)).start();

    }

}
