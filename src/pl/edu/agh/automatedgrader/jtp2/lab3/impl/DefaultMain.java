package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Main;

import java.util.ArrayList;
import java.util.List;

public class DefaultMain implements Main {
    private static int PHILOSOPHERS_COUNT = 5;
    private List<DefaultPhilosopher> philosophers = new ArrayList<>();
    private List<DefaultFork> forks = new ArrayList<>();

    public static void main(String[] args) {
        DefaultMain df = new DefaultMain();
        df.eatingThinking(5, 5, 100, 100);
    }

    @Override
    public void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking) {
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks.add(new DefaultFork());
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Object leftFork = forks.get(i);
            Object rightFork = forks.get((i + 1) % numberOfPhilosophers);

            if(i == numberOfPhilosophers - 1)
                philosophers.add(new DefaultPhilosopher(leftFork, rightFork));
            else
                philosophers.add(new DefaultPhilosopher(rightFork, leftFork));

            Thread t = new Thread(philosophers.get(i), "Philosopher " + (i + 1));
            t.start();
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
