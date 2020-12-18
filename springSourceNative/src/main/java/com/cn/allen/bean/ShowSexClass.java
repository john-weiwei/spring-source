package com.cn.allen.bean;

import org.springframework.beans.factory.annotation.Lookup;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/16
 * @Description:
 */
public abstract class ShowSexClass {
    public void showSex() {
        getPerson().showSex();
    }

    @Lookup("women")
    //不一定是抽象的
    public abstract Person getPerson();
}
