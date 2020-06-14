package pl.edu.agh.automatedgrader.jtp2.lab3.impl;

import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Fork;

public class DefaultFork implements Fork {
    private final int id;
    private static int instanceCount = 0;

    public DefaultFork() {
        this.id = DefaultFork.instanceCount++;
    }

    @Override
    public int getId() {
        return id;
    }
}
