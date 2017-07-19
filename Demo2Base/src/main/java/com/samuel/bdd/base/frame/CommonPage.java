package com.samuel.bdd.base.frame;

import java.util.Collections;
import java.util.List;

public class CommonPage extends AbstractPage {

	@Override
	protected List<String> getLoadIdentifier() {
		return Collections.emptyList();
	}

}
