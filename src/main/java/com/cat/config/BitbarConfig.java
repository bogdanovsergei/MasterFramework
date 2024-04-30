package com.cat.config;

import com.cat.config.converters.StringToOSType;
import com.cat.config.converters.StringToURLConverter;
import com.cat.enums.OSType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${user.dir}/src/test/resources/bitbar.properties"
})
public interface BitbarConfig extends Config {

    @Key("username")
    String userName();
    String key();
    String browserVersion();

    @DefaultValue("https://us-west-desktop-hub.bitbar.com/wd/hub")
    @ConverterClass(StringToURLConverter.class)
    URL bitbarURL();

    @ConverterClass(StringToOSType.class)
    OSType osType();

}
