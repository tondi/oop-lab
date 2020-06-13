package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DefaultConsumer implements Consumer {
	private final Queue<Integer> queue;
	private final List<Integer> consumed = new LinkedList<>();
	private final int howMany;

	private static int instancesCount = 0;
	private final int id;
	
	DefaultConsumer(Queue<Integer> queue, int howMany) {
		this.queue = queue;
		this.howMany = howMany;

		this.id = DefaultConsumer.instancesCount++;
	}
	
    @Override
	public void run() {
		while (consumed.size() != howMany) {
			synchronized(queue) {
				System.out.println("Consumer: " + this.id);
				if(queue.isEmpty()) {
					System.out.println(" queue is empty, waiting");
					System.out.println(" consumes left: " + (howMany - consumed.size()));

					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
				} else {
					Integer value = queue.poll();
					consumed.add(value);
					System.out.println(" consumed value " + value);
					System.out.println(" consumes left: " + (howMany - consumed.size()));
					System.out.println(queue);
					queue.notifyAll();
				}
			}
		}
	}

	@Override
	public List<Integer> getConsumedList() {
		return consumed;
	}

	@Override
	public int getHowMany() {
		return howMany;
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
