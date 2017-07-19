package com.samuel.bdd.core;

import com.samuel.bdd.base.HelloWorld;

public class HelloCore {

	HelloWorld helloWorld;
	public String excute() {
		helloWorld = new HelloWorld();
		return helloWorld.excute();
	}
}
