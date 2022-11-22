package com.utils.ui.components.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.utils.ui.components.interfaces.IHudlLink;


/**
 *  
 *
 */
public abstract class AbstractHudlLinkImpl extends AbstractHudlElementImpl implements IHudlLink {

	
	@Override
	public String getHyperLink() {
		return getWebElementEnabledWithWait().getAttribute("href");
	}

	@Override
	public IHudlLink assertHyperLink(String expLink) {
		assertThat(getHyperLink()).isEqualTo(expLink);
		return this;
	}

	@Override
	public void click() {
		getWebElementEnabledWithWait().click();	
	}
}
