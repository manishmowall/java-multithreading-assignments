package org.nitishm.producer_consumer;

import java.util.List;

class Consumer implements Runnable {
    private final List<Integer> sharedQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println(ex.getStackTrace());
            }
        }
    }

    private void consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("Queue is empty, " + Thread.currentThread().getName() + " is waiting , size: " + sharedQueue.size());
                sharedQueue.wait(3000);
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notify();
            System.out.println(sharedQueue.remove(0) + " element is consumed by " +Thread.currentThread().getName());
        }
    }
}