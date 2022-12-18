package com.teoan.learning.learning.spi.service;

import com.teoan.learning.learning.spi.entity.Order;
import com.teoan.learning.learning.spi.enums.OrderType;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description 工单处理抽象类
 */
@Slf4j
public abstract class OrderHandleServiceImpl implements IOrderHandleService {

    HashMap<OrderType, Consumer<Order>> orderTypeMap = new HashMap<>(3);

    public OrderHandleServiceImpl() {
        orderTypeMap.put(OrderType.开通,this::handelOpenOrder);
        orderTypeMap.put(OrderType.取消,this::handelCancelOrder);
        orderTypeMap.put(OrderType.调整,this::handelAdjustOrder);
    }

    @Override
    public void handelOrder(List<Order> orderList) {
        orderList.forEach(order -> {
            orderTypeMap.get(order.getOrderTpye()).accept(order);
        });
    }



    /**
     * 开通单处理
     * @param order 工单
     */
    protected abstract void handelOpenOrder(Order order);

    /**
     * 调整单处理
     * @param order 工单
     */
    protected abstract void handelAdjustOrder(Order order);

    /**
     * 取消单处理
     * @param order 工单
     */
    protected abstract void handelCancelOrder(Order order);
}
