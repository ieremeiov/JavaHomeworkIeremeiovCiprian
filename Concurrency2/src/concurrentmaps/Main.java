/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        new Thread(new FirstWorker(map)).start();
        new Thread(new SecondWorker(map)).start();

//        List<String> list1 = new ArrayList<>();
//        
//        // list2 will be synchronized
//        List<String> list2 = Collections.synchronizedList(list1);
//

    }

}
