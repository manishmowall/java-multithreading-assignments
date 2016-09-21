package org.webonise.diningphilosophers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {
   private static final int maxPauseTime = 3000;
   private static final int minPauseTime = 1000;
   private final Fork left;
   private final Fork right;
   private final int id;
   private boolean runStatus;

   public Philosopher(Fork left, Fork right, int id) {

      this.left = left;
      this.right = right;
      this.id = id;
      runStatus = true;
   }

   public void run() {

      try {
         while (runStatus) {
            thinking();
            grabLeftFork();
            grabRightFork();
            eating();
            dropForks();
         }
      } catch (InterruptedException interruptedexception) {
         System.out.println(interruptedexception.getStackTrace());
      }
   }

   public void stopPhilosopher() {

      runStatus = false;
   }

   private void thinking() throws InterruptedException {

      System.out.println("Philosopher " + id + " " + "thinking");
      pause();
   }

   private void eating() throws InterruptedException {

      System.out.println("Philosopher " + id + " " + "eating");
      pause();
   }

   //pause for thinking or eating purpose
   private void pause() throws InterruptedException {

      TimeUnit.MILLISECONDS.sleep(getRandomPauseTime(maxPauseTime, minPauseTime));
   }

   //for getting random sleep time(ms) for pause() method between maxTime and minTime
   private int getRandomPauseTime(int maxTime, int minTime) {

      Random random = new Random();
      return random.nextInt((maxTime - minTime) + 1) + minTime;
   }

   private void grabLeftFork() throws InterruptedException {

      System.out.println("Philosopher " + id + " " + "grabbing right");
      left.take();
   }

   private void grabRightFork() throws InterruptedException {

      System.out.println("Philosopher " + id + " " + "grabbing left");
      right.take();
   }

   private void dropForks() {

      System.out.println("Philosopher " + id + " " + "drops both forks");
      right.drop();
      left.drop();
   }
}