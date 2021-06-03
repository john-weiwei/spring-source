package com.cn.allen.bean;

import lombok.Data;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/6
 * @Description:
 */
//@DependsOn("dependsOn2")
@Data
public class DependsOnDemo {

    public DependsOnDemo() {
        System.out.println("执行DependsOnDemo");
    }


    public void dependsOn2() {
        System.out.println("=========");
    }

    private String username;

}

