package com.utils.ui.components.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.utils.ui.components.interfaces.IHudlTextBox;
import com.utils.ui.utils.PageLauncher;
import com.utils.ui.wd.TestWebDriverManager;


/**
 *  
 *
 */
public abstract class AbstractHudlTextBoxImpl extends AbstractHudlElementImpl implements IHudlTextBox {

	private static final Logger LOGGER = Logger.getLogger(AbstractHudlTextBoxImpl.class);
	
	private WebDriver driver = TestWebDriverManager.getDriver();
	
	@Override
	public void setText(String text) {
		if(!getFilledText().isEmpty()) {
			LOGGER.info("There is some text filled: " + getFilledText());
			LOGGER.info("Going to clear the text: " + getFilledText());
			getWebElementEnabledWithWait().clear();
			assertTextBoxFilled("");
		} else {
			LOGGER.info("There is no text filled");
		}
		getWebElementEnabledWithWait().click();
		getWebElementEnabledWithWait().sendKeys(text);	
	}
		
	@Override
	public IHudlTextBox assertTextBoxFilled(String expText) {
		Callable<Boolean> call = () -> {
			LOGGER.info("Expected text: " + expText);
			LOGGER.info("Actual text: " + getFilledText());
			return expText.equals(getFilledText());
		};
		PageLauncher.waitForConditionSatisfied(call, "Text is not matched");
		assertThat(expText).isEqualTo(getFilledText());
		return this;
	}
	private String getFilledText() {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String textEntered = (String) js.executeScript("return arguments[0].value;", getWebElementEnabledWithWait());
			LOGGER.info("Text in text box: " + textEntered);
			return textEntered;
		} catch(Exception e) {
			new AssertionError(e.getMessage());
			return "";
		}
	}
}
