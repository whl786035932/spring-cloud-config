package com.zh.client.fallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName: FallbackableConfigServicePropertySourceLocator
 * @Description: 创建本地的回退文件
 * @Author wanghaili
 * @Date 2019/11/15 10:43
 **/
@Order(0)
public class FallbackableConfigServicePropertySourceLocator extends ConfigServicePropertySourceLocator {

    private boolean fallbackEnabled;
    private String fallbackLocation;

    @Autowired(required = false)
    TextEncryptor textEncryptor;


    public FallbackableConfigServicePropertySourceLocator(ConfigClientProperties defaultProperties, String fallbackLocation){
        super(defaultProperties);
        this.fallbackEnabled= !StringUtils.isEmpty(fallbackLocation);
        this.fallbackLocation = fallbackLocation;
    }

    public PropertySource locate(Environment environment){
        PropertySource<?> propertySource = super.locate(environment);
        if (fallbackEnabled){
            if (propertySource != null){
                storeLocally(propertySource);
            }
        }
        return propertySource;
    }

    private void storeLocally(PropertySource propertySource){
        StringBuilder sb = new StringBuilder();
        CompositePropertySource source = (CompositePropertySource) propertySource;
        for(String propertyName: source.getPropertyNames()){
            Object value = source.getProperty(propertyName);
            if(textEncryptor != null)
                value = "{cipher}"+textEncryptor.encrypt(String.valueOf(value));
            sb.append(propertyName).append("=").append(value).append("\n");
            System.out.println("file contents:" +sb.toString());
            //saveFile
            saveFile(sb.toString());
        }
    }

    private void saveFile(String contents){
        BufferedWriter output=null;
        File file = new File(fallbackLocation + File.separator + ConfigServerBootstrap.FALLBACK_FILE_NAME);
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            output = new BufferedWriter(new FileWriter(file));
            output.write(contents);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (output != null){
                    try{
                        output.close();
                    }catch (IOException e){
                        System.out.println("Error"+e.getMessage());
                    }
                }
            }

        }

}


