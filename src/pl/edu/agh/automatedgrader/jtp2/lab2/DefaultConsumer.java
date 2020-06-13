package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DefaultConsumer implements Consumer {
	private final Queue<Integer> queue;
	private List<Integer> consumed = new LinkedList<>();
	private int howMany;
	private int sizeLimit;
	private Object consumerLock;
	private Object producerLock;

	public static int id = 0;
	public int _id;
	
	DefaultConsumer(Queue<Integer> queue, int howMany, int sizeLimit, Object consumerLock, Object producerLock) {
		this.queue = queue;
		this.howMany = howMany;
		this.sizeLimit = sizeLimit;
		this.consumerLock = consumerLock;
		this.producerLock = producerLock;

		this._id = DefaultConsumer.id++;
	}
	
    @Override
	public void run() {
		while (consumed.size() != howMany) {
			synchronized(queue) {
				System.out.println("Consumer: " + this._id);
				if(queue.isEmpty()) {
					System.out.println(" queue is empty, waiting");
					System.out.println(" consumes left: " + (howMany - consumed.size()));

					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					Integer value = queue.poll();
					consumed.add(value);
					System.out.println(" consumed value " + value);
					System.out.println(" consumes left: " + (howMany - consumed.size()));
					System.out.println(queue);
//					notifyConsumption();
					queue.notifyAll();
				}
			}
		}
	}

	private void notifyConsumption() {
		synchronized (consumerLock) {
			consumerLock.notifyAll();
		}
	}

	private void waitForProduction() {
		synchronized (producerLock) {
			try {
				producerLock.wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
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
