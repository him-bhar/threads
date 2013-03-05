package com.himanshu.waitnotify;

import java.util.UUID;

public class Producer extends Thread {

	private int MAX_SIZE = 10;

	@Override
	public void run() {
		System.out.println(getName() + " - Starting producer thread "+getName());
		while (true) {
			synchronized (SharedProducerConsumerResource.getInstance()) {
				try {
					if (SharedProducerConsumerResource.getInstance().size() == MAX_SIZE) {
						System.out.println(getName() + " - PRODUCER is full!!!");
						SharedProducerConsumerResource.getInstance().wait();
					}
					supplyData();
					SharedProducerConsumerResource.getInstance().notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		//System.out.println("Finished producer thread "+getName());
	}

	public void supplyData() {
		String data = UUID.randomUUID().toString();
		System.out.println(getName() + " - Item produced: "+data);
		SharedProducerConsumerResource.getInstance().add(data);
	}
}
