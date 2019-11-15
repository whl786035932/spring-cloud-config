package com.zh.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: FallbackClientApplication
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/15 11:16
 **/
@SpringBootApplication
@ComponentScan("com.zh.client")
public class FallbackClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(FallbackClientApplication.class,args);

    }
}
