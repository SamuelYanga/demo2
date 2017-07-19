package com.samuel.bdd.action;

import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

import com.samuel.bdd.base.Constants1;

public class ActionTest {

	@Test
	public void test() {
		HelloAction action = new HelloAction();
		System.out.println("****************" + action.fun());
		Assert.assertThat(Constants1.HELLO, equalTo(action.fun()));
	}

}
