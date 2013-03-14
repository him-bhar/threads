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
package com.himanshu.accessmodifiers2;

import com.himanshu.accessmodifiers.ProtectedClass;

public class Main {

	public static void main(String[] args) {
		ProtectedClass protClass = new ProtectedClass();
		//protClass.method1();	//This is protected method but in different package so not accessible
		protClass.method2();	//This is a public method so visible everywhere
		//protClass.method3();	//This is a default scope method, Hence present only in the classes of same package, NOT VISIBLE HERE
		//protClass.method4();	//This is not available since visible only in ProtectedClass


		ExtendedProtectedClass extProtClass = new ExtendedProtectedClass();
		extProtClass.method1();	//This is protected method but in different package in parent class, so  to access it first override the method here and then using super call the method
		extProtClass.method2();	//This is a public method so visible everywhere
		//extProtClass.method3();	//This is a default scope method, Hence present only in the classes of same package
		//protClass.method4();	//This is not available since visible only in ProtectedClass
	}

}
