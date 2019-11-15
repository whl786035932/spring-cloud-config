package com.zh.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: client.ClientConfigApplication
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/12 14:40
 **/
@SpringBootApplication
@ComponentScan("com.zh.client")
public class FreshClientConfigApplication {
    public static void main(String[] args) {
        System.out.println("client start....");
        SpringApplication.run(FreshClientConfigApplication.class,args);
        System.out.println("client end ....");


    }
}
