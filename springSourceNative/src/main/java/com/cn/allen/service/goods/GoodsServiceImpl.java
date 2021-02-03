package com.cn.allen.service.goods;

import com.cn.allen.dao.CommonMapper;
import com.cn.allen.pojo.ZgGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CommonMapper commonMapper;

//    @TargetSource("ds1")
    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void addGoods(ZgGoods zgGoods) {
        int i = commonMapper.addGood(zgGoods);
        // 传播属性是：Propagation.NESTED，这里抛出的异常没有处理，
        //传递到外层方法，即被 transation方法处理，外层事务Propagation.REQUIRED捕获
        //所有外层事务发生回滚，即addArea和addGoods都没有数据
        if (true) throw new RuntimeException("抛异常了");
        System.out.println("添加商品成功");
    }

    @Transactional(readOnly = true)
    @Override
    public List<ZgGoods> queryAll() {
        return commonMapper.queryAll();
    }
}
