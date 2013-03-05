package com.himanshu.threadbeans;

import java.util.UUID;

public class ThreadLocalDemoBean {

	private String name;
	private String guid;

	public ThreadLocalDemoBean(String name) {
		this.name = name;
		guid = UUID.randomUUID().toString();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}

}
