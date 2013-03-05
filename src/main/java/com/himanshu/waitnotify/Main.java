package com.himanshu.waitnotify;

public class Main {

	public static void main(String[] args) {
		Producer p = new Producer();
		p.start();
		Consumer c = new Consumer();
		c.start();
	}

}
