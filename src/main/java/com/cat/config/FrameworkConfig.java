package com.cat.config;

import com.cat.config.converters.StringToBrowserTypeConverter;
import com.cat.enums.BrowserRemoteModeType;
import com.cat.enums.BrowserType;
import com.cat.enums.RunModeBrowserType;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig extends Config {
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @Key("runModeBrowser")
    RunModeBrowserType browserRunMode();
    @Key("browserRemoteMode")
    BrowserRemoteModeType browserRemoteMode();
}
