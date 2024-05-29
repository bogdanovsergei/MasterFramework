package com.cat.config;

import com.cat.config.converters.StringToBrowserTypeConverter;
import com.cat.config.converters.StringToMobilePlatformType;
import com.cat.config.converters.StringToRunModeBrowserTypeConverter;
import com.cat.config.converters.StringToURLConverter;
import com.cat.enums.BrowserType;
import com.cat.enums.MobilePlatformType;
import com.cat.enums.RunModeType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/properties/api.properties"
})
public interface ApiConfig extends Config {

    String access_token();
    String baseUrl();

}
