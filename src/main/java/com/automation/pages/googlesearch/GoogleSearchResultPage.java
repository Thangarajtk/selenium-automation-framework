package com.automation.pages.googlesearch;

import com.automation.driver.manager.DriverManager;
import com.automation.pages.base.BasePage;

public class GoogleSearchResultPage extends BasePage {

	public String getSearchResultsPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
