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
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Counter c = new Counter();
        ThreadA a = new ThreadA(c);
        ThreadB b = new ThreadB(c);
        a.start();
        b.start();
    }
    
}
