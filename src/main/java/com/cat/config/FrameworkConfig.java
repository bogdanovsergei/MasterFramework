package com.cat.config;

import com.cat.config.converters.*;
import com.cat.enums.BrowserRemoteModeType;
import com.cat.enums.BrowserType;
import com.cat.enums.RunModeType;
import org.aeonbits.owner.Config;

import java.net.URL;
import java.time.Duration;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig extends Config {


    long timeout();
    String urlAEM();
    String urlDMT();
    String usernameAEM();
    String passwordAEM();

    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @Key("runModeBrowser")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeType browserRunMode();

    @Key("browserRemoteMode")
    @ConverterClass(StringToRemoteModeBrowserTypeConverter.class)
    BrowserRemoteModeType browserRemoteMode();

    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridURL();


}
