package com.cat.config.factory;

import com.cat.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

    private ConfigFactory(){}

    public static FrameworkConfig getConfig() {

        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }

}
