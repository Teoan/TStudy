package com.teoan.learning.learning.spi.service;

import com.teoan.learning.learning.spi.entity.Order;

import java.util.List;

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
