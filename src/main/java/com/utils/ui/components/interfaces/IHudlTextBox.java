package com.utils.ui.components.interfaces;


/**
 *  
 *
 */
public interface IHudlTextBox extends IHudlElement {

	void setText(String text);
		
	IHudlTextBox assertTextBoxFilled(String expText);
}
