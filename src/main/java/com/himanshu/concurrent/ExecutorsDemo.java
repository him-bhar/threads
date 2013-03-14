/*
 * Copyright 2013 Himanshu Bhardwaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.himanshu.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {

	public static void main(String[] args) {
		List<Runnable> runnables = new ArrayList<Runnable>();
		for(int i=0;i<10;i++) {
			RunnableSupplier supply = new RunnableSupplier();
			supply.setName("Thread-"+i);
			runnables.add(supply);
		}
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (Runnable runnable : runnables) {
			service.execute(runnable);
		}
		System.out.println("Shutdown command sent to executor");
		service.shutdown();
		System.out.println("Shutdown command process");
		try {
			service.awaitTermination(0, TimeUnit.SECONDS);	//This is only used in context of shutting down.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
