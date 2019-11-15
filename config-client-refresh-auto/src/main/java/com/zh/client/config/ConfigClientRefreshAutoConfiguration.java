package com.zh.client.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @ClassName: ConfigClientRefreshAutoConfiguration
 * @Description: 创建client端的自动配置类
 * @Author wanghaili
 * @Date 2019/11/14 15:05
 **/
@Configuration
@ConditionalOnClass(RefreshEndpoint.class)
@ConditionalOnProperty("spring.cloud.config.refreshInterval")
@AutoConfigureAfter(RefreshAutoConfiguration.class)
@EnableScheduling
public class ConfigClientRefreshAutoConfiguration implements SchedulingConfigurer {

    private  static final Log logger  = LogFactory.getLog(ConfigClientRefreshAutoConfiguration.class);

    /**
     * 间隔刷新时间
     */
    @Value("${spring.cloud.config.refreshInterval}")
    private long refreshInterval;

    /**
     * 刷新的端点
     */
    @Autowired
    private RefreshEndpoint refreshEndpoint;

    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        final long interval = getRefreshIntervalInMilliseconds();
        logger.info(String.format("Scheduling config  refresh task with %s second s delay",refreshInterval));
        scheduledTaskRegistrar.addFixedDelayTask(new IntervalTask(new Runnable() {
            public void run() {
                refreshEndpoint.refresh();
            }
        },interval,interval));

    }

    /**
     * 以毫秒为单位返回刷新间隔
     * @return
     */
    private  long getRefreshIntervalInMilliseconds(){
        return  refreshInterval * 1000;

    }

    @ConditionalOnMissingBean(ScheduledAnnotationBeanPostProcessor.class)
    @EnableScheduling
    @Configuration
    protected  static  class  EnableSchedulingConfigProperties{

    }
}
