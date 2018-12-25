package com.slmanju.springcache.hazlecast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;

@Configuration
public class HazlecastConfiguration {

    @Bean
    public Config hazelCastConfig() {
        Config config = new Config();
        config.setInstanceName("hazelcast-cache");
 
        config.getMapConfigs().put("allItemsCache", allItemsCache());
        config.getMapConfigs().put("itemCache", itemCache());
 
        return config;
    }

    private MapConfig itemCache() {
        MapConfig itemCache = new MapConfig();
        itemCache.setTimeToLiveSeconds(60);
        itemCache.setEvictionPolicy(EvictionPolicy.LFU);
        return itemCache;
    }

    private MapConfig allItemsCache() {
        MapConfig allItemsCache = new MapConfig();
        allItemsCache.setTimeToLiveSeconds(60);
        allItemsCache.setEvictionPolicy(EvictionPolicy.LFU);
        return allItemsCache;
    }
    
}
