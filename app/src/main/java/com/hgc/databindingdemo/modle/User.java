package com.hgc.databindingdemo.modle;

/**
 * @Description
 * @Author hanguangchuan
 * Date 2022/8/3 20:50
 */
public class User {

    private String name;

    private String password;

    public User (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
