package com.utils.ui.components.interfaces;

import java.util.List;

/**
 * This is Hudl's Search Bar component.  
 *
 */
public interface IHudlSearchBar extends IHudlElement {

	void search(String text);
		
	IHudlSearchBar assertSearch(String expText);

	IHudlSearchBar assertSuggestions(List<String> expSuggestions);

	void selectExploreOption(String exploreOption);

	void selectSuggestion(String suggestion);
}
