package com.cat.config.factory;

import com.cat.config.BitbarConfig;
import org.aeonbits.owner.ConfigCache;

public final class BitbarConfigFactory {

    private BitbarConfigFactory(){}

    public static BitbarConfig getConfig() {

        return ConfigCache.getOrCreate(BitbarConfig.class);
    }
}
