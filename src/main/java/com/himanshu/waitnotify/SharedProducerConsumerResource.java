package com.himanshu.waitnotify;

import java.util.ArrayList;
import java.util.List;

public class SharedProducerConsumerResource {
	private static List<String> shared = null;

	public static synchronized List<String> getInstance() {
		if (shared == null) {
			shared = new ArrayList<String>();
		} else {
			//NOOP
		}
		return shared;
	}

	/*public void addResource (String str) {
		shared.add(str);
	}*/

}
