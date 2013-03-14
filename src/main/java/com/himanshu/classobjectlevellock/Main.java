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
package com.himanshu.classobjectlevellock;

public class Main {

	public static void main(String[] args) {
		/*ClassLevelLocking classLevel = new ClassLevelLocking();
		ObjectLevelLocking objectLevel = new ObjectLevelLocking();

		classLevel.start();
		objectLevel.start();*/
		final NormalClass norClass = new NormalClass();

		Thread t1 = new Thread() {
			public void run() {
				norClass.objectLockMethod();
			};
		};

		Thread t2 = new Thread() {
			public void run() {
				//norClass.objectLockMethodSynch();
				NormalClass.classLockMethod();
			};
		};

		t1.start();
		t2.start();
	}

}
