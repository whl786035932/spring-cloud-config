package com.zh.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: PlaceHolderConfigClientApplication
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/14 10:13
 **/
@SpringBootApplication
@ComponentScan("com.zh.client")
public class PlaceHolderConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaceHolderConfigClientApplication.class,args);
    }
}
