package com.zh.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: PlaceHolderConfigServerApplication
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/14 10:03
 **/
@SpringBootApplication
@EnableConfigServer
@ComponentScan("com.zh.server")
public class PlaceHolderConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlaceHolderConfigServerApplication.class,args);
    }

}
