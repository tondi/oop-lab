package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Philosopher;

import java.util.Random;

public class DefaultPhilosopher implements Philosopher {
    private final Fork left;
    private final Fork right;
    private int howMany;
    private final int maxTimeForEating;
    private final int maxTimeForThinking;
    private final DefaultWaiter waiter;

    public DefaultPhilosopher(Fork leftFork, Fork rightFork, int howMany, int maxTimeForEating, int maxTimeForThinking, DefaultWaiter waiter) {
        this.left = leftFork;
        this.right = rightFork;
        this.howMany = howMany;
        this.maxTimeForEating = maxTimeForEating;
        this.maxTimeForThinking = maxTimeForThinking;
        this.waiter = waiter;
    }

    public void run() {
        while (howMany > 0) {
            if (Math.random() < 0.5) {
                think();
            } else {
                eat();
            }
            howMany--;
        }
    }

    private void think() {
        try {
            System.out.println(Thread.currentThread().getName() + " Thinking");
            Thread.sleep(new Random().nextInt(maxTimeForThinking));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void eat() {
        synchronized (waiter) {
            waiter.getWaitingPhilosophers().add(this);

            while (getForks()) {
                try {
                    waiter.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            waiter.getWaitingPhilosophers().remove(this);

            try {
                System.out.println(Thread.currentThread().getName() + " Eating");
                Thread.sleep(new Random().nextInt(maxTimeForEating));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // free forks
            waiter.getUsedForks().remove(left);
            waiter.getUsedForks().remove(right);

            waiter.notifyAll();
        }

    }

    private boolean getForks() {
        synchronized (waiter) {
            if (
                !(waiter.getUsedForks().contains(left) || waiter.getUsedForks().contains(right))
            ) {
                waiter.getUsedForks().add(left);
                waiter.getUsedForks().add(right);
                return false;
            }
            return true;
        }
    }

    @Override
    public int getHowMany() {
        return howMany;
    }

    @Override
    public Fork getLeftFork() {
        return left;
    }

    @Override
    public Fork getRightFork() {
        return right;
    }

    @Override
    public DefaultWaiter getDefaultWaiter() {
        return waiter;
    }
}