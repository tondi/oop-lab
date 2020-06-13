package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Philosopher;

public class DefaultPhilosopher implements Philosopher {
    private Object left;
    private Object right;

    public DefaultPhilosopher(Object leftFork, Object rightFork) {
        this.left = leftFork;
        this.right = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Thinking");
                Thread.sleep(((int) (Math.random() * 100)));
                synchronized (left) {
                    System.out.println(Thread.currentThread().getName() + " Getting left fork");
                    Thread.sleep(((int) (Math.random() * 100)));
                    synchronized (right) {
                        System.out.println(Thread.currentThread().getName() + " Getting right fork");
                        Thread.sleep(((int) (Math.random() * 100)));
                        System.out.println(Thread.currentThread().getName() + " Putting down right fork");
                        Thread.sleep(((int) (Math.random() * 100)));
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
        return 0;
    }

    @Override
    public Fork getLeftFork() {
        return null;
    }

    @Override
    public Fork getRightFork() {
        return null;
    }

    @Override
    public DefaultWaiter getDefaultWaiter() {
        return null;
    }
}