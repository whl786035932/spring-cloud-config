package com.zh.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: com.zh.server.ConfigGitApplication
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/12 14:05
 **/
@SpringBootApplication
@EnableConfigServer
@ComponentScan("com.zh.server")
public class ConfigServerApplication {
    public static void main(String[] args) {
        System.out.println("staring");
        SpringApplication.run(ConfigServerApplication.class);
        System.out.println("start end");
    }
}
