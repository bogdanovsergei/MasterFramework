package com.cat.config.factory;

import com.cat.config.ApiConfig;
import com.cat.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;

public final class ApiConfigFactory {

    private ApiConfigFactory(){}

    public static ApiConfig getConfig() {

        return ConfigCache.getOrCreate(ApiConfig.class);
    }

}
