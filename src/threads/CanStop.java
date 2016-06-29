package Threads;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raghunandan
 */
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

class CanStop1 extends Thread {
   private volatile boolean stop = false;
   private int counter = 0;
   public void run() {
      while (!stop && counter < 10000) {
          try {
              System.out.println(counter++);
              Thread.sleep(1000);
          } catch (InterruptedException ex) {
              Logger.getLogger(CanStop1.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      if (stop)
      {
      System.out.println("Detected stop"); 
      System.exit(0);
      }
   }
   public void requestStop() {
      stop = true;
   }
}
public class CanStop {
   public static void main(String[] args) {
      final CanStop1 stoppable = new CanStop1();
      stoppable.start();
      new Timer(true).schedule(new TimerTask() {
         public void run() {
            System.out.println("Requesting stop");
            stoppable.requestStop();
         }
      }, 10000);
   }
} 
