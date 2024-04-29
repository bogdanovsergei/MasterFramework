package com.cat.driver.entity;

import com.cat.enums.BrowserRemoteModeType;
import com.cat.enums.BrowserType;
import com.cat.enums.RunModeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class WebDriverData {
    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
    private RunModeType runModeType;
}

