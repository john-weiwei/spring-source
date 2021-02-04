package com.cn.allen.service.area;

import com.cn.allen.dao.CommonMapper;
import com.cn.allen.pojo.ConsultConfigArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@PropertySource("classpath:config/core/core.properties")
@Service
public class AreaServiceImpl implements AreaService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.url:jdbc}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private CommonMapper commonMapper;

//    @Autowired
//    private GoodsService goodsService;

    @Autowired
    private AreaService areaService;

    //    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = RuntimeException.class)
    @Transactional
    @Override
    public List<ConsultConfigArea> queryAreaFromDB(Map param) {
        logger.info("================从mysql里面查询数据 事务1========================");
        List<ConsultConfigArea> areas = commonMapper.queryAreaByAreaCode(param);

        //不是同一个线程，新建一个事务
        new Thread(() -> areaService.queryAreaFromRedisOne(null)).start();

        areaService.queryAreaFromRedisOne(null);
        return areas;
//        return null;
    }

    @Transactional
    @Override
    public String queryAreaFromRedisOne(Map param) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("================从mysql里面查询数据 事务2========================");
        return "OK";
    }

    @Transactional
    @Override
    public String queryAreaFromRedisTow(Map param) {
        return "OK";
    }


    //    @TargetSource("ds2")
    @Transactional(propagation = Propagation.NESTED)
    @Override
    public int addArea(ConsultConfigArea area) {
        int i = commonMapper.addArea(area);
//        if (true) throw new RuntimeException("抛异常了");
        System.out.println("添加成功");
        return 0;
//        return i;
    }
}
