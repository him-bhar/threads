package com.himanshu.threadbeans;

public class JoinThread extends Thread {

	@Override
	public void run() {
		System.out.println("Started thread "+this.getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished thread "+this.getName());
	}

}
