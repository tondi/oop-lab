package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Waiter;

import java.util.HashSet;
import java.util.Set;

public class DefaultWaiter implements Waiter {
    private Set<Fork> usedForks = new HashSet<>();
    private Set<DefaultPhilosopher> waitingPhilosophers = new HashSet<>();

    @Override
    public Set<Fork> getUsedForks() {
        return usedForks;
    }

    @Override
    public Set<DefaultPhilosopher> getWaitingPhilosophers() {
        return waitingPhilosophers;
    }
}
