package com.ms.springboot.javaconfig.model;

/**
 * @author gonglei
 * @date 2018/7/26 15:01
 */
public class User {
    private String userName;
    private String passWord;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
