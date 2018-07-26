package com.ms.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gonglei
 * @date 2018/7/26 15:57
 */
@Controller
@SpringBootApplication
@Configuration
public class HelloApplication{
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello World! Hello Spring Boot";
    }
    public static void main(String[] args){
        SpringApplication.run(HelloApplication.class,args);
    }

}
