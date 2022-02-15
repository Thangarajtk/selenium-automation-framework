package com.automation.utils.dynamicselector;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DynamicXpathUtils {

	public static String getXpath(String xpath, String value) {
		return String.format(xpath, value);
	}

	public static String getXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1,value2);
	}
}
