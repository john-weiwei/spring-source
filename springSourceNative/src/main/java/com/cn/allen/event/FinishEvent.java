package com.cn.allen.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/22
 * @Description:
 * spring容器加载完成，通过监听器发布一个事件，调用到onApplicationEvent
 * 触发点是spring容器加载完成后会触发
 */
@Component
public class FinishEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("======spring加载完成了！");
    }
}
