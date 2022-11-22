package com.utils.ui.components.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.utils.ui.components.interfaces.IHudlBaseElement;


/**
 *  
 *
 */
public abstract class AbstractBaseElementImpl implements IHudlBaseElement {
	
	private Long DEFAULT_WAIT = 30L;
	
	protected abstract WebElement getWebElement();
	
	@Override
	public boolean isDisplayed() {
		
		if(isElementPresentInDom()) {
			try {
				boolean isDisplayed = new FluentWait<>("")
						.withTimeout(Duration.ofSeconds(DEFAULT_WAIT))
						.ignoring(StaleElementReferenceException.class)
						.ignoring(NoSuchElementException.class)
						.pollingEvery(Duration.ofSeconds(1))
						.until(input -> getWebElement().isDisplayed());
				
				return isDisplayed;
			} catch(TimeoutException ex) {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean isDisplayed(long duration) {
		DEFAULT_WAIT = duration;
		return isDisplayed();
	}
	

	@Override
	public boolean isEnabled() {
		if(isDisplayed()) {
			try {
				boolean isEnabled = new FluentWait<>("")
						.withTimeout(Duration.ofSeconds(DEFAULT_WAIT))
						.ignoring(StaleElementReferenceException.class)
						.ignoring(NoSuchElementException.class)
						.pollingEvery(Duration.ofSeconds(1))
						.until(input -> getWebElement().isEnabled());
				
				return isEnabled;
			} catch(TimeoutException ex) {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean isEnabled(long duration) {
		DEFAULT_WAIT = duration;
		return isEnabled();
	}

	@Override
	public IHudlBaseElement assertDisplayed(long duration) {
		assertThat(isDisplayed(duration)).as("Element is not dispalyed").isTrue();
		return this;
	}

	@Override
	public IHudlBaseElement assertNotDisplayed(long duration) {
		assertThat(isDisplayed(duration)).as("Element is dispalyed").isFalse();
		return this;
	}

	@Override
	public IHudlBaseElement assertEnabled(long duration) {
		DEFAULT_WAIT = duration;
		assertThat(isEnabled()).as("Element is not enabled").isTrue();
		return this;
	}

	@Override
	public IHudlBaseElement assertNotEnabled(long duration) {
		DEFAULT_WAIT = duration;
		assertThat(isEnabled()).as("Element is enabled").isFalse();
		return this;
	}

	protected boolean isElementPresentInDom() {
		try {	
			Wait<WebElement> wait = new FluentWait<WebElement>(getWebElement())
					.withTimeout(Duration.ofSeconds(DEFAULT_WAIT))
					.ignoring(StaleElementReferenceException.class)
					.pollingEvery(Duration.ofSeconds(1));
			return wait.until(isAvailable());
		} catch(TimeoutException ex) {
			return false;
		}
	}
	
	private Function<WebElement, Boolean> isAvailable() {
		return new Function<WebElement, Boolean> () {

			@Override
			public Boolean apply(WebElement t) {
				try {
					if(t == null) {
						return false;
					} 
					return t.getTagName() != null;
				} catch (NoSuchElementException e) {
					return false;
				}
			}
			
		};
	}
	
	
	protected WebElement getWebElementFromDomWithWait() {
		if(isElementPresentInDom())
			return getWebElement();
		else
			return null;
	}
	
	protected WebElement getWebElementEnabledWithWait() {
		if(isEnabled())
			return getWebElement();
		else
			return null;
	}

}
