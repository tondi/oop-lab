package pl.edu.agh.automatedgrader.jtp2.lab2;

import pl.edu.agh.automatedgrader.jtp2.lab2.interfaces.Consumer;

import java.util.List;
import java.util.Queue;

public class DefaultConsumer implements Consumer {
	private Queue<Integer> queue;
	
	public static int id = 0;
	public int _id;
	
	DefaultConsumer(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this._id = DefaultConsumer.id++;
	}
	
    @Override
	public void run() {
		System.out.println("consumer run");

		while(true) {
			synchronized(queue) {
				while (queue.isEmpty()) {
                    System.out.println("Queue is empty, wait");
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
				
				queue.remove();
				System.out.println("From consumer " + this._id + " " + queue.size());
                queue.notifyAll();
			}
		}
	}

	@Override
	public List<Integer> getConsumedList() {
		return null;
	}

	@Override
	public int getHowMany() {
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
