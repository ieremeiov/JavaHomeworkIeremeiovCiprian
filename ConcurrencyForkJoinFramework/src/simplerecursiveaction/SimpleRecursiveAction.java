/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplerecursiveaction;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Cip
 */
public class SimpleRecursiveAction extends RecursiveAction {

    private int simultedWork;

    public SimpleRecursiveAction(int simultedWork) {
        this.simultedWork = simultedWork;
    }
    
    
    
    @Override
    protected void compute() {
        
        if(simultedWork > 100) {
            
            System.out.println("Parallel execution and split task..." + simultedWork);
            // not guaranteed that every single action/task is going to be assigned to every single Thread
            // they will be inserted in the ForkJoinPool and if there is any Thread available, it will execute the given task
            SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simultedWork/2);
            SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simultedWork/2);
            
            simpleRecursiveAction1.fork();
            simpleRecursiveAction2.fork();
        } else {
            System.out.println("No need for parallel execution, sequential alghoritm is OK... " + simultedWork);
        }
        
    }
    
    
    
}
