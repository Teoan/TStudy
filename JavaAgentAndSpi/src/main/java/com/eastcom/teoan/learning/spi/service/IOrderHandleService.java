package com.eastcom.teoan.learning.spi.service;

import com.eastcom.teoan.learning.spi.entity.Order;
import com.eastcom.teoan.learning.spi.enums.OrderType;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description 工单处理接口
 */
public interface IOrderHandleService {

    /**
     * 处理工单
     * @param orderList 工单列表
     */
    void handelOrder(List<Order> orderList);

}
