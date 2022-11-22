package com.utils.ui.components.impl;

import com.utils.ui.components.interfaces.IHudlButton;


/**
 *  
 *
 */
public abstract class AbstractHudlButtonImpl extends AbstractHudlElementImpl implements IHudlButton {

	@Override
	public void click() {
		getWebElementEnabledWithWait().click();	
	}
}
