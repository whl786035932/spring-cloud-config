package com.zh.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ConfigInfoProperties
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/12 14:57
 **/
@Component
@ConfigurationProperties(prefix = "opentsp.gis.inverse")
public class ConfigInfoProperties {
   private  String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
