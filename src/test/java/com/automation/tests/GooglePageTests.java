package com.automation.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.automation.base.BaseTest;
import com.automation.constants.StringConstants;
import com.automation.pages.googlesearch.GoogleSearchPage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.annotations.Test;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GooglePageTests extends BaseTest {

    @Test
    public void googleSearchTest() {
        String title = new GoogleSearchPage()
                .performSearch("Automation")
                .getSearchResultsPageTitle();

        assertThat(title)
                .as("Object is actually null").isNotNull()
                .as("It does not contains expected text").containsIgnoringCase("google search")
                .matches("\\w.*" + StringConstants.GOOGLE_SEARCH_RESULTS_PAGE_TITLE)
                .hasSizeBetween(15, 100);
    }

}
