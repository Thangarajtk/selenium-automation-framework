package com.automation.tests;

import java.util.Map;

import com.automation.annotations.FrameworkAnnotation;
import com.automation.base.BaseTest;
import com.automation.constants.StringConstants;
import com.automation.enums.Authors;
import com.automation.enums.CategoryType;
import com.automation.pages.orangehrm.enums.topmenucomponent.MenuType;
import com.automation.pages.orangehrm.enums.topmenucomponent.SubMenuType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.automation.pages.orangehrm.LoginPage;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrangeHRMTests extends BaseTest {
	
	@Test
	@FrameworkAnnotation(author = {Authors.USER_1, Authors.USER_2},
			category = {CategoryType.REGRESSION, CategoryType.SANITY})
	public void loginLogoutTest(Map<String,String> data) {
		String title = new LoginPage()
				.loginToApplication(data.get("username"), data.get("password"))
				.clickWelcome()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title).isEqualTo(StringConstants.ORANGEHRM_PAGE_TITLE);
	}

	@Test
	@FrameworkAnnotation(author = {Authors.USER_1, Authors.USER_2},
			category = {CategoryType.REGRESSION, CategoryType.SANITY})
	public void testAddUsers(Map<String,String> data) {

		new LoginPage()
				.loginToApplication(data.get("username"), data.get("password"))
				.navigateToAddUsersPage()
				.getAddUserComponent();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
