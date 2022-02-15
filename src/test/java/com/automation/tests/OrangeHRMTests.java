package com.automation.tests;

import java.util.Map;

import com.automation.annotations.FrameworkAnnotation;
import com.automation.base.BaseTest;
import com.automation.enums.CategoryType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.automation.pages.orangehrm.OrangeHRMLoginPage;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrangeHRMTests extends BaseTest {
	
	@Test
	@FrameworkAnnotation(author = {"User1", "User2"},
			category = {CategoryType.REGRESSION, CategoryType.SANITY})
	public void loginLogoutTest(Map<String,String> data) {
		String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("username")).enterPassWord(data.get("password"))
				.clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
