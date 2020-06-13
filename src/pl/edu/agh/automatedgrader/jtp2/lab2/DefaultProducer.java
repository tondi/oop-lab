package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Producer;

import java.util.List;
import java.util.Queue;

public class DefaultProducer implements Producer {
	private Queue<Integer> queue;
	int maxSize;
	
	public static int id = 0;
	public int _id;
	
	DefaultProducer(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
		this._id = DefaultProducer.id++;
	}
	
	@Override
	public void run() {
		System.out.println("producer run");

		while(true) {	 	
			synchronized(queue) {
				while(queue.size() == maxSize) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				queue.add(12);
				System.out.println("From prod " + this._id + " " + queue.size());
				queue.notifyAll();
			}
		}
	}

	@Override
	public List<Integer> getProducedList() {
		return null;
	}

	@Override
	public int getHowMany() {
		return 0;
	}

	@Override
	public int getSizeLimit() {
		return 0;
	}

	@Override
	public Queue<Integer> getQueue() {
		return null;
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
