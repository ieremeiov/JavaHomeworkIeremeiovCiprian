/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentmaps;

import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Cip
 */
public class SecondWorker implements Runnable {

    private ConcurrentMap<String, Integer> map;

    public SecondWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {

        try {
        // makes sure that first worker has enough time to put the values in the map 
            Thread.sleep(2000);
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("E"));
            System.out.println(map.get("F"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
