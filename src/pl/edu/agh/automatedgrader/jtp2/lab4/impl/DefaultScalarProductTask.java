package pl.edu.agh.automatedgrader.jtp2.lab4.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DefaultScalarProductTask extends RecursiveTask<List<Integer>> {
    private static final int SEQUENTIAL_THRESHOLD = 5;

    private List<Vector> vectors;

    DefaultScalarProductTask(List<Vector> vectors) {
        this.vectors = vectors;
    }

    @Override
    protected List<Integer> compute() {
        if (vectors.size() <= SEQUENTIAL_THRESHOLD) {
            return multiplyVectorPairs();
        } else {
            int middle = vectors.size() / 2;
            List<Vector> newList = vectors.subList(middle, vectors.size());
            vectors = vectors.subList(0, middle);
            DefaultScalarProductTask task = new DefaultScalarProductTask(newList);
            task.fork();
            List<Integer> thisResult = this.compute();
            List<Integer> thatResult = task.join();

            List<Integer> result = new ArrayList<>();

            result.addAll(thisResult);
            result.addAll(thatResult);
            return result;
        }
    }

    List<Integer> multiplyVectorPairs() {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < vectors.size() - 1; i += 2) {
            Vector first = vectors.get(i);
            Vector second = vectors.get(i + 1);
            result.add(first.getX() * second.getX() + first.getY() * second.getY());
        }
        return result;
    }
}