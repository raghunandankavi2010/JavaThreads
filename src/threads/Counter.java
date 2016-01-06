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
class Counter {

    private int c = 1;

    public synchronized void printTable(int n) { 
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public synchronized int increment() {
        c++;
        System.out.println("Value increment :"+c);
        return c;
    }

    public synchronized int decrement() {
        c--;
        System.out.println("Value Decrement :"+c);
        return c;
    }

    public synchronized void print(int c) {
         System.out.println("Printing "+c);
    }

}
