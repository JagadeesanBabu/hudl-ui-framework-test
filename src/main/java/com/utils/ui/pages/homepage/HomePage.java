package com.utils.ui.pages.homepage;

import org.openqa.selenium.support.PageFactory;

import com.utils.ui.components.interfaces.IHudlElement;
import com.utils.ui.pages.HudlComponentGetter;
import com.utils.ui.wd.TestWebDriverManager;


public class HomePage extends HudlComponentGetter {

	private HomePageElements getPage() {
		return PageFactory.initElements(TestWebDriverManager.getDriver(), HomePageElements.class);
	}
	
	public IHudlElement getHomeMenu() {
		return getHudlElement(getPage().getHomeMenu());
	}

	public IHudlElement getExploreMenu() {
		return getHudlElement(getPage().getExploreMenu());
	}
	public IHudlElement getUploadElement() {
		return getHudlElement(getPage().getUpload());
	}

	public void assertHomePageElementsDisplayed() {
		getHomeMenu().assertDisplayed();
		getExploreMenu().assertDisplayed();
		getUploadElement().assertDisplayed();
	}
}
