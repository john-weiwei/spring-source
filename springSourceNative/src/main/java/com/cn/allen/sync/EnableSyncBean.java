package com.cn.allen.sync;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/7
 * @Description:
 */
@Component
@EnableAsync
public class EnableSyncBean {

    private Integer corePoolSize = 10;
    private Integer maxPoolSize = 40;
    private Integer queueCapacity = 10;
    private String threadNamePrefix = "AllenExecutor-";

    @Bean
    public Executor executor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(corePoolSize);
        threadPoolExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolExecutor.setQueueCapacity(queueCapacity);
        threadPoolExecutor.setThreadNamePrefix(threadNamePrefix);
        return threadPoolExecutor;
    }
}
