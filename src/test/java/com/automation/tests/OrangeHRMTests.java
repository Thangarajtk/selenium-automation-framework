package com.automation.tests;

import br.com.six2six.fixturefactory.Fixture;
import com.automation.annotations.FrameworkAnnotation;
import com.automation.base.BaseTest;
import com.automation.constants.StringConstants;
import com.automation.enums.Authors;
import com.automation.enums.CategoryType;
import com.automation.fixtures.addusers.entity.UserData;
import com.automation.pages.orangehrm.LoginPage;
import com.automation.pages.orangehrm.pagecomponents.adduserspage.AddUserComponent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrangeHRMTests extends BaseTest {

    BiPredicate<UserData, AddUserComponent> just_employee_name_predicate = (userData, addUserComponent) -> {
        addUserComponent.setEmployeeNameTextBox(userData.getEmployeeName());
        return addUserComponent.isErrorDisplayedForEmployeeName();
    };

    BiPredicate<UserData, AddUserComponent> validPredicate = (userData, addUserComponent) -> {
        addUserComponent.setUserNameTextBox(userData.getUserName())
                .setPasswordTextBox(userData.getPassword())
                .setConfirmPasswordTextBox(userData.getPassword())
                .setStatusDropDown(userData.getStatus())
                .setEmployeeNameTextBox(userData.getEmployeeName());

        return addUserComponent.isSuccessMessageDisplayed();
    };

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

    @DataProvider
    public Object[][] getData() {
		List<UserData> valid = Fixture.from(UserData.class).gimme(1, "valid");
        List<UserData> employeeName = Fixture.from(UserData.class)
                .gimme(1, "just_employee_name");

        return new Object[][]{
                {employeeName, just_employee_name_predicate},
                {valid, validPredicate}
        };
    }

    @Test(dataProvider = "getData", enabled = false)
    @FrameworkAnnotation(author = {Authors.USER_1, Authors.USER_2},
            category = {CategoryType.REGRESSION, CategoryType.SANITY})
    public void testAddUsers(UserData userData, BiPredicate<UserData, AddUserComponent> predicate) {
        boolean isMsgDisplayed = new LoginPage()
                .loginToApplication("Admin", "admin123")
                .navigateToSystemUsersPage()
                .getUserListComponent()
                .setAddButton()
                .fillDetails(userData, predicate);

        Assertions.assertThat(isMsgDisplayed)
                .withFailMessage("Message is not displayed")
                .isTrue();
    }


}
