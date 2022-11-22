package com.utils.ui.components.interfaces;


/**
 *  
 *
 */
public interface IHudlLink extends IHudlElement {

	public void click();
	
	String getHyperLink();
	
	IHudlLink assertHyperLink(String expLink);
}
