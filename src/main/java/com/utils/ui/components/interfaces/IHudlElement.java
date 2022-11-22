package com.utils.ui.components.interfaces;


/**
 *  
 *
 */
public interface IHudlElement extends IHudlBaseElement {

	String getText();
	
	IHudlElement assertTextEqualsTo(String expText);
	
	IHudlElement assertTextContains(String expTextToContain);
}
