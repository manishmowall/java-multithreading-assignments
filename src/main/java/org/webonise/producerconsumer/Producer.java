package org.webonise.producer_consumer;

import java.util.List;

class Producer implements Runnable {
   private final List<Integer> sharedQueue;
   final int queueSize = 4;

   public Producer(List<Integer> sharedQueue) {

      this.sharedQueue = sharedQueue;
   }

   @Override
   public void run() {

      for (int i = 0; i < 7; i++) {
         try {
            produce(i);
         } catch (InterruptedException ex) {
            System.out.println(ex.getStackTrace());
         }
      }
   }

   //sometime thread behave abnormally and resume itself from waiting state
   // so to make sure that thread are in waiting state , I am checking the queue is full or not
   // And if not adding the element and notify the threads.
   private void produce(int element) throws InterruptedException {
      //wait if queue is full
      while (sharedQueue.size() == queueSize) {
         synchronized (sharedQueue) {
            System.out.println("Queue is full, " + Thread.currentThread().getName() + " is waiting, queue size : " + sharedQueue.size());
            sharedQueue.wait();
         }
      }

      //producing element and notify consumers
      synchronized (sharedQueue) {
         sharedQueue.add(element);
         System.out.println(element + " is added in the shared queue by " + Thread.currentThread().getName());
         sharedQueue.notifyAll();
      }
   }
}