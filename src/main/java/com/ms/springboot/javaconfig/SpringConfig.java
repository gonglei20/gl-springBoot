package com.ms.springboot.javaconfig;

import com.ms.springboot.javaconfig.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gonglei
 * @date 2018/7/26 15:13
 */
@Configuration
@ComponentScan(basePackages = "com.ms.springboot.javaconfig") //配置扫描包
public class SpringConfig {

    @Bean
    public UserDao getUserDao(){
        return new UserDao();
    }
}
