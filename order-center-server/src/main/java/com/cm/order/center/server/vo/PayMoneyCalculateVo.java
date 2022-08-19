package com.cm.order.center.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车想要购物商品支付总金额计算
 */
public class PayMoneyCalculateVo implements Serializable {

    /**销售类型：1，普通销售；2，活动销售；3，批发销售*/
    private Integer selltype;

    /**订单金额*/
    private BigDecimal orderMoney;

    /**折扣比例*/
    private BigDecimal discountRate;

    /**折后金额*/
    private BigDecimal discountMoney;

    /**优惠金额*/
    private BigDecimal preferMoney;

    /**运输费用*/
    private BigDecimal postMoney;

    /**支付金额*/
    private BigDecimal payMoney;

    /**支付方式：1，在线支付；2，货到付款*/
    private Integer payModel;
}
