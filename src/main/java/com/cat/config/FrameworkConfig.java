package com.cat.config;

import com.cat.config.converters.*;
import com.cat.enums.BrowserType;
import com.cat.enums.MobilePlatformType;
import com.cat.enums.RunModeType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/properties/config.properties"
})
public interface FrameworkConfig extends Config {

    long timeout();
    long timeoutMobile();
    String urlAEM();
    String urlDMT();
    String usernameAEM();
    String passwordAEM();
    String usernameDMT();
    String passwordDMT();
    String appNameAndroid();
    String appPackage();
    String appActivity();

    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @Key("runModeWeb")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeType runModeWeb();

    @Key("runModeMobile")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeType runModeMobile();

    @DefaultValue("ANDROID")
    @ConverterClass(StringToMobilePlatformType.class)
    MobilePlatformType mobilePlatformLocal();

    @DefaultValue("http://127.0.0.1:4723")
    @ConverterClass(StringToURLConverter.class)
    URL localURL();

}
