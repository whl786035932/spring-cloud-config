package com.zh.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: client.ClientConfigApplication
 * @Description: https://www.jianshu.com/p/ac6dda3115c6  测试自动刷新，success
 * @Author wanghaili
 * @Date 2019/11/12 14:40
 **/
@SpringBootApplication
@ComponentScan("com.zh.client")
public class AutoFreshClientConfigApplication {
    public static void main(String[] args) {
        System.out.println("client start....");
        SpringApplication.run(AutoFreshClientConfigApplication.class,args);
        System.out.println("client end ....");


    }
}
