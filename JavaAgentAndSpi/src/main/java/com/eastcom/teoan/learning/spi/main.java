package com.eastcom.teoan.learning.spi;

import com.eastcom.teoan.learning.spi.entity.Order;
import com.eastcom.teoan.learning.spi.enums.OrderType;
import com.eastcom.teoan.learning.spi.service.IOrderHandleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description
 */
public class main {
    public static void main(String[] args) {
        //模拟工单
        List<Order> orderList = new ArrayList<>(3);
        orderList.add(Order.builder().title("开通单").orderTpye(OrderType.开通).build());
        orderList.add(Order.builder().title("取消单").orderTpye(OrderType.取消).build());
        orderList.add(Order.builder().title("调整单").orderTpye(OrderType.调整).build());

        //根据spi机制加载对应环境的处理方式
        ServiceLoader<IOrderHandleService> serviceLoader = ServiceLoader.load(IOrderHandleService.class);
        serviceLoader.forEach(iOrderHandleService -> {
           iOrderHandleService.handelOrder(orderList);
        });
    }
}
