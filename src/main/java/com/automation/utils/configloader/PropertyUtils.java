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

	private static Properties property;

	// Singleton design pattern
	public static Properties getInstance() {
		if (property == null) {
			property = new Properties();
		}
		return property;
	}

	static void loadProperties(String propertyFilePath) {
		Exceptions.wrap(e -> new PropertyFileUsageException("Exception occurred while loading Property file in the specified path - " + propertyFilePath))
				.run(() -> getInstance().load(new FileInputStream(propertyFilePath)));
	}

	public static String get(ConfigProperties key) {
		loadProperties(FrameworkConstants.CONFIG_PROPERTIES_FILE_PATH);
		if (Objects.isNull(property.getProperty(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name - " + key + " is not found. Please check the config.properties");
		}
		return property.getProperty(key.name().toLowerCase());
	}
}
