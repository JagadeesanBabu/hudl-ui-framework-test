package com.utils.ui.components.interfaces;


/**
 *  
 *
 */
public interface IHudlBaseElement {

	boolean isDisplayed();
	
	boolean isDisplayed(long duration);
	
	boolean isEnabled();
	
	boolean isEnabled(long duration);
	
	IHudlBaseElement assertDisplayed(long duration);
	
	IHudlBaseElement assertNotDisplayed(long duration);
	
	IHudlBaseElement assertEnabled(long duration);
	
	IHudlBaseElement assertNotEnabled(long duration);
	
	default IHudlBaseElement assertDisplayed() {
		return assertDisplayed(30L);
	}
	
	default IHudlBaseElement assertNotDisplayed() {
		return assertNotDisplayed(3L);
	}
	
	default IHudlBaseElement assertEnabled() {
		return assertEnabled(30L);
	}
	
	default IHudlBaseElement assertNotEnabled() {
		return assertNotEnabled(3L);
	}
}
