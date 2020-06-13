package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Waiter;

import java.util.Set;

public class DefaultWaiter implements Waiter {
    @Override
    public Set<Fork> getUsedForks() {
        return null;
    }

    @Override
    public Set<DefaultPhilosopher> getWaitingPhilosophers() {
        return null;
    }
}
