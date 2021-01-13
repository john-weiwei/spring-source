package com.cn.allen.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/5
 * @Description:
 */
@Service
public class CircularRetB {

    public CircularRetB() {
        System.out.println("======CircularRetB()=====");
    }

    @Autowired
    private CircularRetA A;
}
