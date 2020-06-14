package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Philosopher;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Waiter;

public class DefaultPhilosopher implements Philosopher {
    private final Fork left;
    private final Fork right;
    private int howMany;
    private int maxTimeForEating;
    private int maxTimeForThinking;
    private DefaultWaiter waiter;

    public DefaultPhilosopher(Fork leftFork, Fork rightFork, int howMany, int maxTimeForEating, int maxTimeForThinking, DefaultWaiter waiter) {
        this.left = leftFork;
        this.right = rightFork;
        this.howMany = howMany;
        this.maxTimeForEating = maxTimeForEating;
        this.maxTimeForThinking = maxTimeForThinking;
        this.waiter = waiter;
    }

    @Override
    public void run() {
        try {
            while (howMany > 0) {
                System.out.println(Thread.currentThread().getName() + " Thinking");
                Thread.sleep(((int) (Math.random() * maxTimeForThinking)));
                howMany--;
                synchronized (left) {
                    System.out.println(Thread.currentThread().getName() + " Getting left fork");
//                    Thread.sleep(((int) (Math.random() * 100)));
                    synchronized (right) {
                        System.out.println(Thread.currentThread().getName() + " Getting right fork");
                        Thread.sleep(((int) (Math.random() * maxTimeForEating)));
                        System.out.println(Thread.currentThread().getName() + " Putting down right fork");
//                        Thread.sleep(((int) (Math.random() * 100)));
                    }
                    System.out.println(Thread.currentThread().getName() + " Putting down the left fork");
                    Thread.sleep(((int) (Math.random() * 100)));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
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