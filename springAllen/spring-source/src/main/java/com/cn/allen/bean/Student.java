package com.cn.allen.bean;

import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/11/27
 * @Description:
 */
@Service
public class Student {
    private String username = "Allen";
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
