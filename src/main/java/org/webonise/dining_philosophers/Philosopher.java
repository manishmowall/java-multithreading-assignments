package org.webonise.dining_philosophers;

import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {
   private final Fork left;
   private final Fork right;
   private final String id;
   private final Thread thread;

   public Philosopher(Fork left, Fork right, int id) {

      this.left = left;
      this.right = right;
      this.id = "" + id;
      thread = new Thread(this, this.id);
      thread.start();
   }

   public void run() {

      try {
         //to take thread out of loop and stop
         int i = 0;
         while (i < 5) {
            System.out.println("Philosopher " + id + " " + "thinking");
            pause();
            System.out.println("Philosopher " + id + " " + "grabbing right");
            right.take();
            System.out.println("Philosopher " + id + " " + "grabbing left");
            left.take();
            System.out.println("Philosopher " + id + " " + "eating");
            pause();
            right.drop();
            left.drop();
            i++;
         }
      } catch (InterruptedException ex) {
         System.out.println(ex.getStackTrace());
      }
   }

   //pause for thinking or eating purpose
   private void pause() throws InterruptedException {

      TimeUnit.MILLISECONDS.sleep(1000);
   }
}