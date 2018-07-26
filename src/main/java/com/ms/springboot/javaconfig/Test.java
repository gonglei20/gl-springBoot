package com.ms.springboot.javaconfig;

import com.ms.springboot.javaconfig.dao.UserDao;
import com.ms.springboot.javaconfig.model.User;
import com.ms.springboot.javaconfig.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author gonglei
 * @date 2018/7/26 15:18
 */
public class Test {
    public static void main(String[] args){
        //实例化Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //在Spring容器中获取Bean对象
        UserService userService = context.getBean(UserService.class);
        //调用对象中的方法
        List<User> userList = userService.queryUserList();
        //遍历打印
        for (User user : userList){
            System.out.println(user.getUserName()+"="+user.getPassWord()+"="+user.getAge());
        }

    }

}
