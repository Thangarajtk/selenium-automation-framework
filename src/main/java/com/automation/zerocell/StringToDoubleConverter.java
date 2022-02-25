package com.automation.zerocell;

import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;

public class StringToDoubleConverter implements Converter<Double> {

    @Override
    public Double convert(Method method, String s) {
        return Double.valueOf(s);
    }
}
