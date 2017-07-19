package com.samuel.bdd.base.frame;

public abstract class AbstractComponent extends AbstractPage {
	public String getCurrentUrl() {
		return this.myDriver.getCurrentUrl();
	}
}
