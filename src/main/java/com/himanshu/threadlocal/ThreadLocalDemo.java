package com.himanshu.threadlocal;

import com.himanshu.threadbeans.ThreadLocalDemoBean;
import com.himanshu.threadbeans.ThreadLocalProvider;

/**
 * ThreadLocal is like a session per thread
 * @author himanshu bhardwaj
 *
 */
public class ThreadLocalDemo {
	public static void main(String[] args) {
		Thread thread1 = new Thread("Thread-1") {
			@Override
			public void run() {
				System.out.println("Inside "+this.getName());
				ThreadLocalDemoBean demoBean1 = ThreadLocalProvider.getThreadLocalDemoBeanObject();
				System.out.println(this.getName()+": Name :\t"+demoBean1.getName());
				System.out.println(this.getName()+": GUID :\t"+demoBean1.getGuid());
				demoBean1.setName("Test Done!!!");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(this.getName()+": Updated Name in thread :\t"+demoBean1.getName());

				System.out.println(this.getName()+": Pulling again from threadlocal");
				ThreadLocalDemoBean demoBean2 = ThreadLocalProvider.getThreadLocalDemoBeanObject();
				System.out.println(this.getName()+": Name from threadlocal :\t"+demoBean2.getName());
				System.out.println(this.getName()+": GUID from threadlocal :\t"+demoBean2.getGuid());

				System.out.println("Finished "+this.getName());
			}
		};
		thread1.start();


		Thread thread2 = new Thread("Thread-2") {
			@Override
			public void run() {
				System.out.println("Inside "+this.getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ThreadLocalDemoBean demoBean1 = ThreadLocalProvider.getThreadLocalDemoBeanObject();
				System.out.println(this.getName()+": Name :\t"+demoBean1.getName());
				System.out.println(this.getName()+": GUID :\t"+demoBean1.getGuid());
				System.out.println("Finished "+this.getName());
			}
		};
		thread2.start();
//		thread1.start(); 		YOU CANNOT START A THREAD WHICH IS ALREADY STATRTED YOU WILL GET "java.lang.IllegalThreadStateException"
		try {
			thread2.join();
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("EXITING MAIN THREAD");
	}
}

