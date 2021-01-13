package com.cn.allen.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/30
 * @Description:
 */
@Service
@Data
public class ConstructAutowiredBean {
    private Student student;

    //触发依赖注入的引用类型的getBean操作
    @Autowired
    public ConstructAutowiredBean(Student student) {
        this.student = student;
    }

    @PostConstruct
    private void initMethod() {
        System.out.println("post construct");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("destroy this method");
    }
}
