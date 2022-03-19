package com.automation.config.converter;

import com.automation.enums.RunType;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.util.Map;

public class StringToRunTypeConverter implements Converter<RunType> {

    @Override
    public RunType convert(Method method, String runType) {
        Map<String, RunType> stringRunTypeMap = Map.
                of("LOCAL", RunType.LOCAL,
                        "REMOTE", RunType.REMOTE);

        return stringRunTypeMap.getOrDefault(runType.toUpperCase(), RunType.LOCAL);
    }
}
