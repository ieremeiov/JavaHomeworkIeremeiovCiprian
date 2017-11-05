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
public class FirstWorker implements Runnable {

    private ConcurrentMap<String, Integer> map;

    public FirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {

        try {

            map.put("B", 1);
            map.put("H", 2);
            Thread.sleep(1000);
            map.put("F", 3);
            map.put("A", 4);
            Thread.sleep(1000);
            map.put("E", 5);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
