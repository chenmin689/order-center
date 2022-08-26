package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.server.vo.PayMoneyAmountVo;
import com.cm.order.center.server.vo.PayMoneyCalculateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

/**
 * 订单支付结果汇总
 */
@Service("calculateResultLogic")
@Slf4j
public class CalculateResultLogic implements ILogic<WeixinRequestBean,PayMoneyAmountVo> {

    @Override
    public PayMoneyAmountVo exec(WeixinRequestBean weixinRequestBean) {

        BigDecimal realPayMoney = new BigDecimal(0);
        BigDecimal orderMoney = new BigDecimal(0);
        BigDecimal discountMoney = new BigDecimal(0);
        PayMoneyAmountVo vo = new PayMoneyAmountVo();
        if(weixinRequestBean.getCheckKey("commonPayMoney")){
            PayMoneyCalculateVo comm = (PayMoneyCalculateVo) weixinRequestBean.getParameter().get("commonPayMoney");
            vo.setCommonPayMoney(comm);
            realPayMoney = realPayMoney.add(comm.getPayMoney());
            orderMoney = orderMoney.add(comm.getOrderMoney());
            discountMoney = discountMoney.add(comm.getPreferMoney());
        }

        if(weixinRequestBean.getCheckKey("sellPayMoney")){
            PayMoneyCalculateVo sell = (PayMoneyCalculateVo) weixinRequestBean.getParameter().get("sellPayMoney");
            vo.setCommonPayMoney(sell);
            realPayMoney = realPayMoney.add(sell.getPayMoney());
            orderMoney = orderMoney.add(sell.getOrderMoney());
            discountMoney = discountMoney.add(sell.getPreferMoney());
        }

        if(weixinRequestBean.getCheckKey("batchPayMoney")){
            PayMoneyCalculateVo batch = (PayMoneyCalculateVo) weixinRequestBean.getParameter().get("batchPayMoney");
            vo.setCommonPayMoney(batch);
            realPayMoney = realPayMoney.add(batch.getPayMoney());
            orderMoney = orderMoney.add(batch.getOrderMoney());
            discountMoney = discountMoney.add(batch.getPreferMoney());
        }
        vo.setRealPayMoney(realPayMoney);
        vo.setOrderMoney(orderMoney);
        vo.setDiscountMoney(discountMoney);
        return vo;
    }
}
