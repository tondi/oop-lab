package pl.edu.agh.automatedgrader.jtp2.lab4.impl;

import pl.edu.agh.automatedgrader.jtp2.lab4.interfaces.Main;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class DefaultMain implements Main {
    public static void main(String[] args) {
        DefaultMain df = new DefaultMain();


        List<Double> first = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0));
        List<Double> second = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0));

        df.computeScalarProduct(first, second);
    }

    @Override
    public double computeScalarProduct(List<Double> first, List<Double> second) {
        List<Vector> vectors = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            vectors.add(new Vector(new Random().nextInt(), new Random().nextInt()));
            System.out.println(vectors.get(i).getX() + " " + vectors.get(i).getY());
        }

        Instant start = Instant.now();
        System.out.println(ForkJoinPool.commonPool().invoke(new DefaultScalarProductTask(vectors)));
        System.out.println("Time: " + Duration.between(start, Instant.now()).toMillis()); // 8ms

        return 0;
    }

    @Override
    public ForkJoinTask<Double> getForkJoinTask() {
        return null;
    }
}

