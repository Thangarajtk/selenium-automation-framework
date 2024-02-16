package com.automation.tests;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.automation.annotations.FrameworkAnnotation;
import com.automation.base.BaseTest;
import com.automation.constants.StringConstants;
import com.automation.enums.Authors;
import com.automation.enums.CategoryType;
import com.automation.pages.orangehrm.HomePageAssert;
import com.automation.pages.orangehrm.LoginPage;
import com.automation.pages.orangehrm.enums.AddUsersScenarioType;
import com.automation.pages.orangehrm.validator.HomePageValidator;
import io.github.sskorol.core.DataSupplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrangeHRMTests extends BaseTest {

    @Test
    @FrameworkAnnotation(author = {Authors.USER_1, Authors.USER_2},
            category = {CategoryType.REGRESSION, CategoryType.SANITY})
    public void loginLogoutTest(Map<String, String> data) {
        String title = new LoginPage()
                .loginToApplication(data.get("username"), data.get("password"))
                .clickWelcome()
                .clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo(StringConstants.ORANGEHRM_PAGE_TITLE);
    }

    @DataSupplier(runInParallel = true)
    public Stream<AddUsersScenarioType> getData() {
        FixtureFactoryLoader.loadTemplates("com.automation.fixtures.addusers");
        return Stream.of(AddUsersScenarioType.values());
    }

    @Test(dataProvider = "getData", enabled = false)
    @FrameworkAnnotation(author = {Authors.USER_1, Authors.USER_2},
            category = {CategoryType.REGRESSION, CategoryType.SANITY})
    public void testAddUsers(AddUsersScenarioType addUsersScenarioType) {
        boolean isMsgDisplayed = new LoginPage()
                .loginToApplication("Admin", "admin123")
                .navigateToSystemUsersPage()
                .getUserListComponent()
                .setAddButton()
                .fillDetails(addUsersScenarioType.getUserData(), addUsersScenarioType.getPredicate());

        Assertions.assertThat(isMsgDisplayed)
                .withFailMessage(() -> addUsersScenarioType.getUserData().getMessage())
                .isTrue();
    }

    @Test
    @FrameworkAnnotation(author = {Authors.USER_1, Authors.USER_2},
            category = {CategoryType.REGRESSION, CategoryType.SANITY})
    public void testHomePageComponents() {
        HomePageValidator homePageValidator = new LoginPage()
                .loginToApplication("Admin", "admin123")
                .getHomePageValidator();

        HomePageAssert.assertThat(homePageValidator)
                .isMarketPlaceLinkPresent()
                .headerNameEquals("Dashboard")
                .logoSourceStringContains("/images/logo.png")
                .assertAll();
    }
}
