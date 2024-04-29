package com.cat.config.factory;

import com.cat.config.BrowserStackConfig;
import org.aeonbits.owner.ConfigCache;

public final class BrowserStackConfigFactory {

    private BrowserStackConfigFactory(){}

    public static BrowserStackConfig getConfig() {

        return ConfigCache.getOrCreate(BrowserStackConfig.class);
    }
}
