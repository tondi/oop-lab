package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Main;

import java.util.ArrayList;
import java.util.List;

public class DefaultMain implements Main {
    private final List<DefaultPhilosopher> philosophers = new ArrayList<>();
    private final List<DefaultFork> forks = new ArrayList<>();
    DefaultWaiter waiter = new DefaultWaiter();;

    public static void main(String[] args) {
        DefaultMain df = new DefaultMain();
        df.eatingThinking(1, 3, 100, 100);
    }

    @Override
    public void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking) {
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks.add(new DefaultFork());
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            philosophers.add(new DefaultPhilosopher(forks.get((i + 1) % numberOfPhilosophers), forks.get(i), howMany, maxTimeForEating, maxTimeForThinking, waiter));
        }

        List<Thread> threads = new ArrayList<>(numberOfPhilosophers);
        for (int i = 0; i < numberOfPhilosophers; i++) {
            threads.add(new Thread(philosophers.get(i), "Philosopher " + (i + 1)));
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public List<DefaultFork> getForks() {
        return forks;
    }

    @Override
    public List<DefaultPhilosopher> getPhilosophers() {
        return philosophers;
    }

    @Override
    public DefaultWaiter getDefaultWaiter() {
        return null;
    }
}
