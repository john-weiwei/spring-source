package com.cn.allen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/14
 * @Description:
 */
// @Primary：有多个类实现同一个接口的前提下，会优先使用加了@Primary注解的类
@Primary
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountService accountService;

    @Override
    public String queryUser(String userId) {
        System.out.println("userServiceImpl -> "+userId);
        return "userServiceImpl"+userId;
    }
}
