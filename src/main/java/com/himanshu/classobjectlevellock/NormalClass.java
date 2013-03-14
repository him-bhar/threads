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


public class NormalClass {

	public synchronized static void classLockMethod() {
		while (true) {
			System.out.println("Captured class level lock 3333");
		}
	}

	public void objectLockMethod() {
		synchronized (this) {
			while (true) {
				System.out.println("Captured object level lock 1111");
			}
		}
	}

	public static void classLockMethodSynch() {
		synchronized (NormalClass.class) {
			while (true) {
				System.out.println("Captured class level lock 4444");
			}
		}
	}

	public void objectLockMethodSynch() {
		synchronized (this) {
			while (true) {
				System.out.println("Captured object level lock 2222");
			}
		}
	}
}
