package com.cat.config.converters;

import com.cat.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserName) {
        Map<String, BrowserType> stringBrowserTypeMap = Map.
                of("CHROME", BrowserType.CHROME,
                        "EDGE", BrowserType.EDGE);
        return stringBrowserTypeMap
                .getOrDefault(browserName.toUpperCase(), BrowserType.CHROME);
    }
}

