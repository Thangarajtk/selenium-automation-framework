package com.automation.utils.configloader;

import com.automation.constants.FrameworkConstants;
import com.automation.enums.ConfigProperties;
import com.automation.exceptions.PropertyFileUsageException;
import com.machinezoo.noexception.Exceptions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertyUtils {

	private static final Properties property = new Properties();

	static void loadProperties(String propertyFilePath) {
		Exceptions.wrap(e -> new PropertyFileUsageException("Exception occurred while loading Property file in the specified path - " + propertyFilePath))
				.run(() -> property.load(new FileInputStream(propertyFilePath)));
	}

	public static String get(ConfigProperties key) {
		loadProperties(FrameworkConstants.getPropertiesFilePath());
		if (Objects.isNull(property.getProperty(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name - " + key + " is not found. Please check the config.properties");
		}
		return property.getProperty(key.name().toLowerCase());
	}
}
