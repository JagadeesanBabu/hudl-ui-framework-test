package com.utils.ui.pages;

import org.openqa.selenium.WebElement;

import com.utils.ui.components.impl.AbstractBaseElementImpl;
import com.utils.ui.components.impl.AbstractHudlButtonImpl;
import com.utils.ui.components.impl.AbstractHudlElementImpl;
import com.utils.ui.components.impl.AbstractHudlLinkImpl;
import com.utils.ui.components.impl.AbstractHudlTextBoxImpl;
import com.utils.ui.components.interfaces.IHudlBaseElement;
import com.utils.ui.components.interfaces.IHudlButton;
import com.utils.ui.components.interfaces.IHudlElement;
import com.utils.ui.components.interfaces.IHudlLink;
import com.utils.ui.components.interfaces.IHudlTextBox;

public class HudlComponentGetter {

	protected IHudlLink getLink(WebElement element) {
		return new AbstractHudlLinkImpl() {

			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}

	protected IHudlTextBox getTextBox(WebElement element) {
		return new AbstractHudlTextBoxImpl() {

			@Override
			protected WebElement getWebElement() {
				return element;
			}
			
			
		};
	}
	
	protected IHudlElement getText(WebElement element) {
		return new AbstractHudlElementImpl() {

			@Override
			protected WebElement getWebElement() {
				return element;
			}
			
			
		};
	}
	
	protected IHudlButton getButton(WebElement element) {
		return new AbstractHudlButtonImpl() {

			@Override
			protected WebElement getWebElement() {
				return element;
			}
			
			
		};
	}

	protected IHudlElement getHudlElement(WebElement element) {
		return new AbstractHudlElementImpl() {
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}

}
