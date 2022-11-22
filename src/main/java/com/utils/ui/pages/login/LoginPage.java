package com.utils.ui.pages.login;

import org.openqa.selenium.support.PageFactory;

import com.utils.ui.components.interfaces.IHudlBaseElement;
import com.utils.ui.components.interfaces.IHudlButton;
import com.utils.ui.components.interfaces.IHudlLink;
import com.utils.ui.components.interfaces.IHudlTextBox;
import com.utils.ui.pages.HudlComponentGetter;
import com.utils.ui.wd.TestWebDriverManager;


public class LoginPage extends HudlComponentGetter {

	private LoginPageElements getPage() {
		return PageFactory.initElements(TestWebDriverManager.getDriver(), LoginPageElements.class);
	}
	
	// header links
	
	public IHudlLink getSignInLink() {
		return getLink(getPage().getSignInLink());
	}
	
	public IHudlLink getSignUpLink() {
		return getLink(getPage().getSignUpLink());
	}

	public IHudlTextBox getUserEmailTextBox() {
		return getTextBox(getPage().getUsername());
	}

	public IHudlTextBox getPasswordTextBox() {
		return getTextBox(getPage().getPassword());
	}

	public IHudlButton getSignInButton() {
		return getButton(getPage().getLoginButton());
	}

	public IHudlBaseElement getErrElement() {
		return getButton(getPage().getLoginButton());
	}

	public void login(String username, String password) {
		getUserEmailTextBox().assertDisplayed();
		getUserEmailTextBox().setText(username);
		getPasswordTextBox().setText(password);
		getPasswordTextBox().assertTextBoxFilled(password);
		getSignInButton().click();

	}

	public void assertLoginError() {
		getHudlElement(getPage().getErrorDisplayElement()).assertDisplayed();
	}
}
