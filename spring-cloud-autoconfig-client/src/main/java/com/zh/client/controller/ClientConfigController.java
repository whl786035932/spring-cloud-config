package com.zh.client.controller;

import com.zh.client.config.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ClientConfigController
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/12 15:02
 **/
@RefreshScope
@RestController
public class ClientConfigController {
    @Autowired
    private ConfigInfoProperties configInfoProperties;

    @RequestMapping("getConfig")
    public String getConfigInfo(){
        return  configInfoProperties.getUrl();
    }
}
