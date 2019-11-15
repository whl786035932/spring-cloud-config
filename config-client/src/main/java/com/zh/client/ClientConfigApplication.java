package com.zh.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: ClientConfigApplication
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/12 14:40
 **/
@SpringBootApplication
@ComponentScan("com.zh.client")
public class ClientConfigApplication {
    public static void main(String[] args) {
        System.out.println("client start....");
        SpringApplication.run(ClientConfigApplication.class,args);
        System.out.println("client end ....");


    }
}
