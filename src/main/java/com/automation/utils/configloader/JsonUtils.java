package com.automation.utils.configloader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.automation.constants.FrameworkConstants;
import com.automation.enums.ConfigJson;
import com.automation.exceptions.JsonFileUsageException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {

    private static final Map<String, String> map;

    static {
        try {
            map = new ObjectMapper().readValue(new File(FrameworkConstants.JSON_CONFIG_FILE_PATH),
                    new TypeReference<HashMap<String, String>>() {
                    });

		} catch (IOException e) {
			throw new JsonFileUsageException("IOException occurred while reading Json file in the specified path");
		}
    }

    public static String get(ConfigJson key) {
        if (Objects.isNull(key) || Objects.isNull(map.get(key.name().toLowerCase()))) {
            throw new JsonFileUsageException("Property name " + key + " is not found. Please check config.json");
        }
        return map.get(key.name().toLowerCase());
    }
}
