package com.teoan.learning.learning.spi.entity;

import com.teoan.learning.learning.spi.enums.OrderType;
import lombok.Builder;
import lombok.Data;

/**
 * @author Teoan
 * @date 2022/4/18 22:44
 * @description 工单对象
 */
@Data
@Builder
public class Order {

    /**
     * 工单标题
     */
    String title;

    /**
     * 工单类型
     */
    OrderType orderTpye;


}
