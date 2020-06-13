package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DefaultProducer implements Producer {
	private final Queue<Integer> queue;
	private final int howMany;
	private final int sizeLimit;
	private final List<Integer> produced = new ArrayList<>();

	private static int instancesCount = 0;
	private final int id;
	
	DefaultProducer(Queue<Integer> queue, int howMany, int sizeLimit) {
		this.queue = queue;
		this.howMany = howMany;
		this.sizeLimit = sizeLimit;

		this.id = DefaultProducer.instancesCount++;
	}
	
	@Override
	public void run() {
		while(produced.size() != howMany) {
			synchronized(queue) {
				System.out.println("Producer: " + this.id);
				if (queue.size() < sizeLimit) {
					queue.add(12);
					produced.add(12);
					System.out.println(" produced value");
					System.out.println(" produces left: " + (howMany - produced.size()));
					System.out.println(queue);
					queue.notifyAll();
				} else {
					System.out.println(" queue is full. waiting");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
				}
			}
		}

	}

	@Override
	public List<Integer> getProducedList() {
		return produced;
	}

	@Override
	public int getHowMany() {
		return howMany;
	}

	@Override
	public int getSizeLimit() {
		return sizeLimit;
	}

	@Override
	public Queue<Integer> getQueue() {
		return queue;
	}

	@Override
	public Object getConsumerLock() {
		return null;
	}

	@Override
	public Object getProducerLock() {
		return null;
	}
}
