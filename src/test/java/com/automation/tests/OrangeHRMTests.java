package com.automation.tests;

import br.com.six2six.fixturefactory.Fixture;
import com.automation.annotations.FrameworkAnnotation;
import com.automation.base.BaseTest;
import com.automation.constants.StringConstants;
import com.automation.enums.Authors;
import com.automation.enums.CategoryType;
import com.automation.fixtures.addusers.entity.UserData;
import com.automation.pages.orangehrm.LoginPage;
import io.github.sskorol.core.DataSupplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

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

	@DataSupplier
	public List<UserData> getData() {
		List<UserData> data = Fixture.from(UserData.class)
				.gimme(1, "valid");
		return data;
	}

	@Test(dataProvider = "getData", enabled = false)
	@FrameworkAnnotation(author = {Authors.USER_1, Authors.USER_2},
			category = {CategoryType.REGRESSION, CategoryType.SANITY})
	public void testAddUsers(UserData userData) {

		new LoginPage()
				.loginToApplication("Admin", "admin123")
				.navigateToSystemUsersPage()
				.getUserListComponent()
				.setAddButton()
				.fillDetails(userData);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
