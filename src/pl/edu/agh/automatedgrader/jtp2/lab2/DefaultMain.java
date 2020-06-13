package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Consumer;
import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Main;
import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Producer;

import java.util.*;

public class DefaultMain implements Main {

    private List<Consumer> consumers = new ArrayList<>();
    private List<Producer> producers = new ArrayList<>();
    private Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        DefaultMain main = new DefaultMain();

        int howMany = 3;
        int sizeLimit = 3;
        int consumerCount = 5;
        int producerCount = 3;

        main.produceConsume(howMany, sizeLimit, consumerCount, producerCount);
    }

    @Override
    public void produceConsume(int howMany, int sizeLimit, int consumerCount, int producerCount) throws InterruptedException {

        for (int i = 0; i < consumerCount; i++) {
            consumers.add(new DefaultConsumer(queue, sizeLimit));
        }

        for (int i = 0; i < producerCount; i++) {
            producers.add(new DefaultProducer(queue, sizeLimit));
        }

        List<Thread> threads = new ArrayList<>();

        consumers.forEach(consumer -> threads.add(new Thread(consumer)));
        producers.forEach(producer -> threads.add(new Thread(producer)));

        threads.forEach(Thread::start);

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch(InterruptedException ex) {
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
