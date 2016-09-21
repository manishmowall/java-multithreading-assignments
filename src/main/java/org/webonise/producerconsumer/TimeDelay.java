package org.webonise.producerconsumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Delay {
   public static void getRandomDelay(int maxPauseTime, int minPauseTime) throws InterruptedException {

      TimeUnit.MILLISECONDS.sleep(getRandomPauseTime(maxPauseTime, minPauseTime));
   }

   //for getting random sleep time(ms) for getRandomDelay() method between maxTime and minTime
   private static int getRandomPauseTime(int maxTime, int minTime) {

      Random random = new Random();
      return random.nextInt((maxTime - minTime) + 1) + minTime;
   }
}
