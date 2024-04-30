package com.cat.config.converters;

import com.cat.enums.BrowserType;
import com.cat.enums.OSType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToOSType implements Converter<OSType> {
    @Override
    public OSType convert(Method method, String osName) {
        Map<String, OSType> stringOSTypeMap = Map.
                of("WINDOWS", OSType.WINDOWS,
                        "MACOS", OSType.MACOS,
                        "LINUX", OSType.LINUX);
        return stringOSTypeMap
                .getOrDefault(osName.toUpperCase(), OSType.WINDOWS);
    }
}
