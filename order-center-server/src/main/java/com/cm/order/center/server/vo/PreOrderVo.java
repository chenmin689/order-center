package com.cm.order.center.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * description: 生成订单的前置信息
 * @author chenmin
 * @version 1.0.0
 * @date 2022/09/03 10:44:40
 */
@Data
public class PreOrderVo implements Serializable {

    /**
     * 真实支付金额
     */
    private BigDecimal realPayMoney;

    /**
     * 商品汇总金额
     */
    private BigDecimal orderMoney;

    /**
     * 优惠金额
     */
    private BigDecimal discountMoney;

    /**
     * 邮费
     */
    private BigDecimal postMoney;

    public PreOrderVo(){
        super();
    }

    public PreOrderVo(BigDecimal realPayMoney, BigDecimal orderMoney, BigDecimal discountMoney, BigDecimal postMoney) {
        this.realPayMoney = realPayMoney;
        this.orderMoney = orderMoney;
        this.discountMoney = discountMoney;
        this.postMoney = postMoney;
    }
}
