package com.cn.allen.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/5
 * @Description:
 */
//@Service
public class CircularRetConA {

    @Autowired
    public CircularRetConA(CircularRetConB B) {
        System.out.println("========CircularRetA()=====");
    }

}
