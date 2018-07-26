package com.ms.springboot.javaconfig.service;


import com.ms.springboot.javaconfig.dao.UserDao;
import com.ms.springboot.javaconfig.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gonglei
 * @date 2018/7/26 15:10
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryUserList(){
        return this.userDao.queryUserList();
    }
}
