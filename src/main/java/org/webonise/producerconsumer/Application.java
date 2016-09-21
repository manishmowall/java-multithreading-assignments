package org.webonise.producer_consumer;

import java.util.ArrayList;
import java.util.List;

//here we are having one producer and two consumers.
public class Application {
   public static void main(String args[]) {
      //this is queue which is shared among the threads.
      List<Integer> sharedQueue = new ArrayList<>();

      Thread producerThread = new Thread(new Producer(sharedQueue), "Producer");
      Thread consumerThread1 = new Thread(new Consumer(sharedQueue), "Consumer1");
      Thread consumerThread2 = new Thread(new Consumer(sharedQueue), "Consumer2");
      producerThread.start();
      consumerThread1.start();
      consumerThread2.start();

      System.out.println("Waiting for child threads to close");
      try {
         producerThread.join();
         consumerThread1.join();
         consumerThread1.join();
      } catch (InterruptedException ex) {
         System.out.println(ex.getStackTrace());
      }

      System.out.println("Main thread exits");
   }
}
