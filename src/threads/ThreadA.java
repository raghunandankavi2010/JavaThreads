/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Raghunandan
 */
public class ThreadA extends Thread{

    private Counter counter;
    public ThreadA(Counter counter)
    {
        this.counter = counter;
    }
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        //counter.printTable(100);
        int val =counter.increment();
         try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
       counter.print(val);
    }
    
    
    
}
