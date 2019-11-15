package com.zh.client.fallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName: ConfigServerBootstrap
 * @Description: 创建自动配置类
 * file;{spring.cloud.config.fallbackLocation:}/fallback.properties  ： 要回退本地配置文件所在的文件和名称
 * 主要是将加载到远程配置文件在本地创建一份，进行备份
 * @Author wanghaili
 * @Date 2019/11/14 16:46
 **/
@Configuration
@EnableConfigurationProperties
@PropertySource(value = {"configClient.properties","file:{spring.cloud.config.fallbackLocation:}/fallback.properties"},ignoreResourceNotFound = true)
public class ConfigServerBootstrap {
    public static  final String FALLBACK_FILE_NAME ="fallback.properties";


    private final  ConfigurableEnvironment configurableEnvironment;



    //要回退配置文件的路径
    @Value("${spring.cloud.config.fallbackLocation:}")
    private  String fallbackLocation;

    /**
     * 因为在@ProperySource中已经将配置文件configClient.properties注入到spring 容器中，所以不需要再初始化该Bean
     */

    private final  ConfigClientProperties configClientProperties;

    @Autowired
    public ConfigServerBootstrap (ConfigurableEnvironment configurableEnvironment, ConfigClientProperties configClientProperties){
       this.configurableEnvironment = configurableEnvironment;
       this.configClientProperties = configClientProperties;
       this.configClientProperties.setEnabled(false);
    }

    @Autowired
    private  ConfigClientProperties clientProperties;
    @Bean
    public FallbackableConfigServicePropertySourceLocator fallbackableConfigServicePropertySourceLocator(){
        FallbackableConfigServicePropertySourceLocator fallbackableConfigServicePropertySourceLocator = new FallbackableConfigServicePropertySourceLocator(clientProperties, fallbackLocation);
        return  fallbackableConfigServicePropertySourceLocator;

    }







}
