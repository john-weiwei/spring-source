package com.cn.allen.service.goods;


import com.cn.allen.pojo.ZgGoods;

import java.util.List;

public interface GoodsService {

    void addGoods(ZgGoods zgGoods);

    List<ZgGoods> queryAll();
}
