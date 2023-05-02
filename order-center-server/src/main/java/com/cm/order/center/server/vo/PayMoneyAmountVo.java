package com.cm.order.center.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员需要支付的总金额
 */
@Data
public class PayMoneyAmountVo implements Serializable {

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

    private PayMoneyCalculateVo commonPayMoney;

    private PayMoneyCalculateVo sellPayMoney;
}
