package com.cn.allen.service.transaction;


import com.cn.allen.pojo.ConsultConfigArea;
import com.cn.allen.pojo.ZgGoods;

public interface TransationService {

    void transation(ConsultConfigArea area, ZgGoods zgGoods);

    int getTicket();

    int getTicketModeOne();
}
