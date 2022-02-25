package com.automation.tests;

import java.util.Map;
import com.automation.base.BaseTest;
import com.automation.zerocell.TestData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.automation.annotations.FrameworkAnnotation;
import com.automation.enums.CategoryType;
import com.automation.pages.amazon.AmazonHomePage;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AmazonDemoTest extends BaseTest {

    @Test
    @FrameworkAnnotation(author = {"User1", "User2"},
            category = {CategoryType.REGRESSION, CategoryType.SANITY})
    public void amazonTest(TestData data) {
        String title = new AmazonHomePage().clickHamburger()
                .clickComputer()
                .clickOnSubMenuItem(data.getMenuToSelect()).getTitle();

        Assertions.assertThat(title).isNotNull();
    }
}
