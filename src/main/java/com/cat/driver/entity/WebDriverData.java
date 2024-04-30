package com.cat.driver.entity;

import com.cat.enums.BrowserType;
import com.cat.enums.OSType;
import com.cat.enums.RunModeType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WebDriverData {
    private BrowserType browserType;
    private RunModeType runModeType;
    private OSType osType;
    private String browserVersion;

}

