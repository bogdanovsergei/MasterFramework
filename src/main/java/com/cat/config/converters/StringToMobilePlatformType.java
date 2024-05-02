package com.cat.config.converters;

import com.cat.enums.MobilePlatformType;
import com.cat.enums.OSType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToMobilePlatformType implements Converter<MobilePlatformType> {
    @Override
    public MobilePlatformType convert(Method method, String mobilePlatformName) {
        Map<String, MobilePlatformType> stringMobilePlatformTypeMap = Map.
                of("ANDROID", MobilePlatformType.ANDROID,
                        "IOS", MobilePlatformType.IOS);
        return stringMobilePlatformTypeMap
                .getOrDefault(mobilePlatformName.toUpperCase(), MobilePlatformType.ANDROID);
    }
}
