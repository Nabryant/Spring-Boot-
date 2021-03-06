package com.example.domain;

import java.io.Serializable;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/5
 * Function:
 */
public class User implements Serializable{

    private static final long serialVersionUID = -1L;
    private String userName;
    private Integer age;

    public User (String userName, Integer age) {
        this.age = age;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
