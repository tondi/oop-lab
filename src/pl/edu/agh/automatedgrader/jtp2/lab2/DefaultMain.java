package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Consumer;
import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Main;
import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Producer;

import java.util.*;

public class DefaultMain implements Main {

    private final List<Consumer> consumers = new ArrayList<>();
    private final List<Producer> producers = new ArrayList<>();
    private final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        DefaultMain main = new DefaultMain();

        int howMany = 1;
        int sizeLimit = 1;
        int consumerCount = 2;
        int producerCount = 1;

        main.produceConsume(howMany, sizeLimit, consumerCount, producerCount);
    }

    @Override
    public void produceConsume(int howMany, int sizeLimit, int consumerCount, int producerCount) throws InterruptedException {

        for (int i = 0; i < consumerCount; i++) {
            consumers.add(new DefaultConsumer(queue, howMany));
        }
        for (int i = 0; i < producerCount; i++) {
            producers.add(new DefaultProducer(queue, howMany, sizeLimit));
        }

        List<Thread> threads = new ArrayList<>();
        consumers.forEach(consumer -> threads.add(new Thread(consumer)));
        producers.forEach(producer -> threads.add(new Thread(producer)));
        threads.forEach(Thread::start);

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public List<Consumer> getConsumers() {
        return this.consumers;
    }

    @Override
    public List<Producer> getProducers() {
        return this.producers;
    }

    @Override
    public Queue<Integer> getQueue() {
        return this.queue;
    }
}
