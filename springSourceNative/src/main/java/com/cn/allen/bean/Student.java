package com.cn.allen.bean;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/11/27
 * @Description:
 */
@Service
@Data
public class Student {
    private String username = "Allen";
    private String password = "123456";
}
