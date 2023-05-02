package com.cm.order.center.server.services;

import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.order.center.server.vo.OrderVo;
import com.cm.order.center.server.vo.PayMoneyAmountVo;
import com.cm.order.center.server.vo.PayOrderVo;
import com.cm.order.center.server.vo.PreOrderVo;

/**
 * description: 微信小程序下单接口
 * @author chenmin
 * @version 1.0.0
 * @date 2022/09/03 10:31:43
 */
public interface WeixinOrderService {

    /**
     * @description: 生成订单之前的数据确认和设置
     * @param weixinRequestBean
     * @return WeixinResponesBean<PreOrderVo>
     */
    public WeixinResponesBean<PreOrderVo> preOrder(WeixinRequestBean weixinRequestBean);

    /**
     * @description: 生成订单
     * @param weixinRequestBean
     * @return WeixinResponesBean<OrderVo>
     */
    public WeixinResponesBean<OrderVo> generateOrder(WeixinRequestBean weixinRequestBean);

    /**
     * @description: 去支付
     * @param weixinRequestBean
     * @return WeixinResponesBean<OrderVo>
     */
    public WeixinResponesBean<PayOrderVo> payOrder(WeixinRequestBean weixinRequestBean);
}
