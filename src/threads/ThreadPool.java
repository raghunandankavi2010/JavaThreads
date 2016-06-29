/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Raghunandan
 */
public class ThreadPool {

    public static void main(String args[]) {
       ExecutorService service = Executors.newFixedThreadPool(10); // fixed thread pool
       for (int i =0; i<100; i++){
           service.submit(new Task(i)); // submit task
       }
    }
  
}

final class Task implements Runnable{ 
    private int taskId;
  
    public Task(int id){
        this.taskId = id;
    }
  
    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId +" performed by " 
                           + Thread.currentThread().getName());
    }
  
}


//Read more: 
//http://javarevisited.blogspot.com/2013/07/how-to-create-thread-pools-in-java-executors-framework-example-tutorial.html#ixzz4CyB0jQsn