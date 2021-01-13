package com.cn.allen.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/16
 * @Description:
 */
@Data
@ToString
@AllArgsConstructor
public class ConstructorArgBean {

    private String username;

    private String password;

    private Student student;

    //在构造函数上加@Autowired的作用是：从spring容器中拿到bean实例，并注入到构造函数
//    @Autowired
    public ConstructorArgBean(Student student) {
        this.student = student;
    }

    public ConstructorArgBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
