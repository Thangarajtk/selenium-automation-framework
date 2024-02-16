package com.automation.tests;

import com.automation.annotations.FrameworkAnnotation;
import com.automation.base.BaseTest;
import com.automation.constants.StringConstants;
import com.automation.enums.Authors;
import com.automation.enums.CategoryType;
import com.automation.pages.googlesearch.GoogleSearchPage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GooglePageTests extends BaseTest {

    @Test
    @FrameworkAnnotation(author = {Authors.USER_1}, category = {CategoryType.SANITY})
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
