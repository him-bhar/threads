package com.himanshu.threadbeans;


public class ThreadLocalProvider {
	private static final ThreadLocal<ThreadLocalDemoBean> var = new ThreadLocal<ThreadLocalDemoBean>() {
		protected ThreadLocalDemoBean initialValue() {
			return new ThreadLocalDemoBean("Test");
		};
	};

	public static ThreadLocalDemoBean getThreadLocalDemoBeanObject() {
		return var.get();
	}
}

