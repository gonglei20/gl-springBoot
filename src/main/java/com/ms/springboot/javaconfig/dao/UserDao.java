package com.ms.springboot.javaconfig.dao;

import com.ms.springboot.javaconfig.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gonglei
 * @date 2018/7/26 15:04
 */
public class UserDao {
    public List<User> queryUserList(){
        List<User> result = new ArrayList<User>();
        for (int i = 0;i<10;i++){
            User user = new User();
            user.setUserName("userName_"+i);
            user.setPassWord("passWord"+i);
            user.setAge(i);
            result.add(user);
        }
        return result;
    }
}
