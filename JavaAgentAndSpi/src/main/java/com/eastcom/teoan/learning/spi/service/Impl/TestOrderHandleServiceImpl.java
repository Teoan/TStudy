package com.eastcom.teoan.learning.spi.service.Impl;

import com.eastcom.teoan.learning.spi.entity.Order;
import com.eastcom.teoan.learning.spi.enums.OrderType;
import com.eastcom.teoan.learning.spi.service.IOrderHandleService;
import com.eastcom.teoan.learning.spi.service.OrderHandleServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description 测试环境工单处理器
 */
@Slf4j
public class TestOrderHandleServiceImpl extends OrderHandleServiceImpl {


    @Override
    public void handelOpenOrder(Order order) {
        log.info("测试环境开始处理开通工单，工单标题[{}],工单类型[{}]",order.getTitle(),order.getOrderTpye().name());
    }

    @Override
    public void handelAdjustOrder(Order order) {
        log.info("测试环境开始处理调整工单，工单标题[{}],工单类型[{}]",order.getTitle(),order.getOrderTpye().name());
    }

    @Override
    public void handelCancelOrder(Order order) {
        log.info("测试环境开始处理取消工单，工单标题[{}],工单类型[{}]",order.getTitle(),order.getOrderTpye().name());
    }
}
