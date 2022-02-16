package com.automation.pages.googlesearch;

import com.automation.enums.WaitStrategy;
import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;

public class GoogleSearchPage extends BasePage {

	private final By txtFieldSearch = By.xpath("//input[@aria-label='Search']");

	public GoogleSearchResultPage performSearch(String searchText) {
		sendKeysAndPressEnter(txtFieldSearch, searchText, WaitStrategy.PRESENCE,"Search text box");
		return new GoogleSearchResultPage();
	}
}
