package com.automation.pages.orangehrm;

import com.automation.pages.base.BasePage;
import org.openqa.selenium.By;

import com.automation.enums.WaitStrategy;
import com.automation.utils.decoder.DecodeUtils;

public final class LoginPage extends BasePage {

	private static final By TEXT_BOX_USERNAME = By.id("txtUsername");
	private static final By TEXT_BOX_PASSWORD = By.xpath("//input[@id='txtPassword' and @type='password']");
	private static final By BUTTON_LOGIN = By.id("btnLogin");

	private LoginPage enterUserName(String username) {
		sendKeys(TEXT_BOX_USERNAME, username, WaitStrategy.PRESENCE, "Username");
		return this;
	}

	private LoginPage enterPassWord(String password) {
		sendKeys(TEXT_BOX_PASSWORD, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password");
		return this;
	}
	private HomePage clickLogin() {
		click(BUTTON_LOGIN, WaitStrategy.PRESENCE, "Login Button");
		return new HomePage();
	}

	public HomePage loginToApplication(String username, String password) {
		return enterUserName(username)
				.enterPassWord(password)
				.clickLogin();
	}

	public String getTitle() {
		return getPageTitle();
	}
	
	
}
