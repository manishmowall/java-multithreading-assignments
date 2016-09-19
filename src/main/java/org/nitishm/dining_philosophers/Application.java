package org.nitishm.dining_philosophers;

public class Application {
    public static void main(String[] args) {
        //size - no of forks/philosophers
        int size = 5;

        //array of forks
        Fork[] forks = new Fork[size];

        //creating object of Fork for each index of forks array
        for (int i = 0; i < size; i++) {
            forks[i] = new Fork();
        }

        //Philosopher objects are created as a separate threads.
        // Also to avoid deadlock condition,
        // at the beginning the last philosopher is trying to
        // grabbing left fork before right fork and all
        // other philosophers are trying to grab right fork first.
        for (int i = 0; i < size; i++) {
            if (i < (size - 1)) {
                new Philosopher(
                        forks[i], forks[i + 1], i);
            } else {
                new Philosopher(
                        forks[0], forks[i], i);
            }
        }
    }
}