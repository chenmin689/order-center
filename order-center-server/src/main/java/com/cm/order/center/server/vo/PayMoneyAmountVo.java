package com.cm.order.center.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员需要支付的总金额
 */
@Data
public class PayMoneyAmountVo implements Serializable {

    private BigDecimal realPayMoney;

    private BigDecimal orderMoney;

    private BigDecimal discountMoney;

    private BigDecimal postMoney;

    private PayMoneyCalculateVo commonPayMoney;

    private PayMoneyCalculateVo sellPayMoney;

    private PayMoneyCalculateVo batchPayMoney;
}
