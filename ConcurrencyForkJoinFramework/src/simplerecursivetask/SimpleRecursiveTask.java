/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplerecursivetask;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Cip
 */
public class SimpleRecursiveTask extends RecursiveTask<Integer> {

    private int simulatedWork;

    public SimpleRecursiveTask(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected Integer compute() {

        if (simulatedWork > 100) {

            System.out.println("Parallel execution needed because of the huge task..." + simulatedWork);
            
            SimpleRecursiveTask task1 = new SimpleRecursiveTask(simulatedWork/2);            
            SimpleRecursiveTask task2 = new SimpleRecursiveTask(simulatedWork/2);
            
            task1.fork();
            task2.fork();
            
            int solution = 0;
            solution += task1.join();
            solution += task2.join();
            
            return solution;
            
        } else {
            System.out.println("No need for parallel execution... " + simulatedWork);
            return 2 * simulatedWork;
        }

    }

}
