package com.teoan.learning.learning.spi.service.Impl;

import com.teoan.learning.learning.spi.entity.Order;
import com.teoan.learning.learning.spi.service.OrderHandleServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description 正式环境工单处理器
 */
@Slf4j
public class ProOrderHandleServiceImpl extends OrderHandleServiceImpl {


    @Override
    public void handelOpenOrder(Order order) {
        log.info("正式环境开始处理开通工单，工单标题[{}],工单类型[{}]",order.getTitle(),order.getOrderTpye().name());
    }

    @Override
    public void handelAdjustOrder(Order order) {
        log.info("正式环境开始处理调整工单，工单标题[{}],工单类型[{}]",order.getTitle(),order.getOrderTpye().name());
    }

    @Override
    public void handelCancelOrder(Order order) {
        log.info("正式环境开始处理取消工单，工单标题[{}],工单类型[{}]",order.getTitle(),order.getOrderTpye().name());
    }
}
