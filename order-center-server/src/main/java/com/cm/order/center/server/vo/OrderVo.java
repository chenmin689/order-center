package com.cm.order.center.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * description: 订单信息
 *
 * @author chenmin
 * @version 1.0.0
 * @date 2022/09/03 10:49:19
 */
@Data
public class OrderVo implements Serializable {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 真实支付金额
     */
    private BigDecimal realPayMoney;

}
