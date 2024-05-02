package com.cat.config;

import com.cat.config.converters.StringToBrowserTypeConverter;
import com.cat.config.converters.StringToMobilePlatformType;
import com.cat.config.converters.StringToOSType;
import com.cat.config.converters.StringToURLConverter;
import com.cat.enums.BrowserType;
import com.cat.enums.MobilePlatformType;
import com.cat.enums.OSType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${user.dir}/src/test/resources/bitbar.properties"
})
public interface BitbarConfig extends Config {

//WEB
    String key();
    String browserVersion();

    @DefaultValue("https://us-west-desktop-hub.bitbar.com/wd/hub")
    @ConverterClass(StringToURLConverter.class)
    URL bitbarURLWeb();

    @ConverterClass(StringToOSType.class)
    OSType osType();

//MOBILE
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType remoteBrowser();

    @DefaultValue("https://us-west-desktop-hub.bitbar.com/wd/hub")
    @ConverterClass(StringToURLConverter.class)
    URL bitbarURLMobile();

    @DefaultValue("ANDROID")
    @ConverterClass(StringToMobilePlatformType.class)
    MobilePlatformType mobilePlatform();

}
