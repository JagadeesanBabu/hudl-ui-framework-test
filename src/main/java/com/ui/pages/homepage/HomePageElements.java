package com.utils.ui.pages.homepage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {

	@FindBy(css = "[data-qa-id='webnav-globalnav-home']")
	private WebElement homeMenu;

	@FindBy(css = "[data-qa-id='webnav-globalnav-explore']")
	private WebElement exploreMenu;
	
	@FindBy(css = ".hui-globalnav__upload--button-display")
	private WebElement upload;

	public WebElement getHomeMenu() {
		return homeMenu;
	}
	public WebElement getExploreMenu() {
		return exploreMenu;
	}
	public WebElement getUpload() {
		return upload;
	}
}
