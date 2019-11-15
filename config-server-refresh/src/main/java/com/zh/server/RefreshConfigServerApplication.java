package com.zh.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: com.zh.server.ConfigGitApplication
 * @Description: 自动刷新的服务端 ， 用于项目config-client-refresh /   spring-cloud-autoconfig-client 的配置中心
 * @Author wanghaili
 * @Date 2019/11/12 14:05
 **/
@SpringBootApplication
@EnableConfigServer
@ComponentScan("com.zh.server")
public class RefreshConfigServerApplication {
    public static void main(String[] args) {
        System.out.println("staring");
        SpringApplication.run(RefreshConfigServerApplication.class);
        System.out.println("start end");
    }
}
