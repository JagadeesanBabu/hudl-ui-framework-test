package com.utils.ui.components.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static java.lang.String.format;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.utils.ui.components.interfaces.IHudlElement;
import com.utils.ui.utils.PageLauncher;


/**
 *  
 *
 */
public abstract class AbstractHudlElementImpl extends AbstractBaseElementImpl implements IHudlElement {

	private static final Logger LOGGER = Logger.getLogger(AbstractHudlElementImpl.class);
	
	@Override
	public String getText() {
		return getWebElementEnabledWithWait().getText();
	}

	@Override
	public IHudlElement assertTextEqualsTo(String expText) {
		
		Callable<Boolean> call = () -> {
			LOGGER.info("Exp Test: " + expText);
			LOGGER.info("Actual Test: " + getText());
			return expText.equals(getText());
		};
		PageLauncher.waitForConditionSatisfied(call, format("Acutal text %s is not matched with expected %s", getText(), expText));
		assertThat(getText()).isEqualTo(expText);
		return this;
	}

	@Override
	public IHudlElement assertTextContains(String expTextToContain) {
		
		Callable<Boolean> call = () -> getText().contains(expTextToContain);
		PageLauncher.waitForConditionSatisfied(call, "Text is not matched");
		
		assertThat(getText()).contains(expTextToContain);
		return this;
	}
}
