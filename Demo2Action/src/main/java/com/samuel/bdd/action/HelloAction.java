package com.samuel.bdd.action;

import com.samuel.bdd.core.HelloCore;

public class HelloAction {

	public String fun() {
		HelloCore hello = new HelloCore();
		return hello.excute();
	}
}
