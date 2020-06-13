package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Main;

import java.util.ArrayList;
import java.util.List;

public class DefaultMain implements Main {
    private static int PHILOSOPHERS_COUNT = 5;

    public static void main(String[] args) {
        List<DefaultPhilosopher> philosophers = new ArrayList<>();
        List<Object> forks = new ArrayList<>();

        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            forks.add(new Object());
        }

        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            Object leftFork = forks.get(i);
            Object rightFork = forks.get((i + 1) % PHILOSOPHERS_COUNT);

            if(i == PHILOSOPHERS_COUNT - 1)
                philosophers.add(new DefaultPhilosopher(leftFork, rightFork));
            else
                philosophers.add(new DefaultPhilosopher(rightFork, leftFork));

            Thread t = new Thread(philosophers.get(i), "Philosopher " + (i + 1));
            t.start();
        }
    }

    @Override
    public void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking) {

    }

    @Override
    public List<DefaultFork> getForks() {
        return null;
    }

    @Override
    public List<DefaultPhilosopher> getPhilosophers() {
        return null;
    }

    @Override
    public DefaultWaiter getDefaultWaiter() {
        return null;
    }
}
