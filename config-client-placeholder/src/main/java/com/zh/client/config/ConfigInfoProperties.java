package com.zh.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ClassName: client.com.zh.server.config.ConfigInfoProperties
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/12 14:57
 **/
@Component
@RefreshScope //被@RefreshScope 修饰的Bean 都是延迟加载的， 只有在第一次访问才会加载
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
