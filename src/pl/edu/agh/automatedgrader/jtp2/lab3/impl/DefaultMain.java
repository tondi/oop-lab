package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Main;

import java.util.ArrayList;
import java.util.List;

public class DefaultMain implements Main {
    private List<DefaultPhilosopher> philosophers = new ArrayList<>();
    private List<DefaultFork> forks = new ArrayList<>();
    DefaultWaiter waiter;

    public static void main(String[] args) {
        DefaultMain df = new DefaultMain();
        df.eatingThinking(1, 3, 100, 100);
    }

    @Override
    public void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking) {
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks.add(new DefaultFork());
        }

        waiter = new DefaultWaiter();

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks.get(i);
            Fork rightFork = forks.get((i + 1) % numberOfPhilosophers);

            System.out.println("forks: " + leftFork.getId() + " " + rightFork.getId() + " for philosopher " + i);

            if(i == numberOfPhilosophers - 1)
                philosophers.add(new DefaultPhilosopher(leftFork, rightFork, howMany, maxTimeForEating, maxTimeForThinking, waiter));
            else
                philosophers.add(new DefaultPhilosopher(rightFork, leftFork, howMany, maxTimeForEating, maxTimeForThinking, waiter));

            Thread t = new Thread(philosophers.get(i), "Philosopher " + (i + 1));
            t.start();
        }

        System.out.println();
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
