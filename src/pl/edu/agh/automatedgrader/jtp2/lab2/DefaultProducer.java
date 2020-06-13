package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DefaultProducer implements Producer {
	private Queue<Integer> queue;
	private int howMany;
	private int sizeLimit;
	private List<Integer> produced = new ArrayList<>();
	private Object consumerLock;
	private Object producerLock;


	public static int id = 0;
	public int _id;
	
	DefaultProducer(Queue<Integer> queue, int howMany, int sizeLimit, Object consumerLock, Object producerLock) {
		this.queue = queue;
		this.howMany = howMany;
		this.sizeLimit = sizeLimit;
		this.consumerLock = consumerLock;
		this.producerLock = producerLock;

		this._id = DefaultProducer.id++;
	}
	
	@Override
	public void run() {
		while(produced.size() != howMany) {
			synchronized(queue) {
				System.out.println("Producer: " + this._id);
				if (queue.size() < sizeLimit) {
					queue.add(12);
					produced.add(12);
					System.out.println(" produced value");
					System.out.println(" produces left: " + (howMany - produced.size()));
					System.out.println(queue);
//					notifyProduction();
					queue.notifyAll();
				} else {
					System.out.println(" queue is full. waiting");
//					waitForConsumption();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	private void notifyProduction() {
		synchronized (producerLock) {
			producerLock.notifyAll();
		}
	}


	private void waitForConsumption() {
		synchronized (consumerLock) {
			try {
				consumerLock.wait();
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
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
