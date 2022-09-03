package com.cm.order.center.server.controller;

import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.order.center.server.vo.OrderVo;
import com.cm.order.center.server.vo.PayOrderVo;
import com.cm.order.center.server.vo.PreOrderVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 微信小程序下单控制器
 * @author chenmin
 * @version 1.0.0
 * @date 2022/09/03 10:31:43
 */
@RestController
@RequestMapping("weixin")
public class WeixinOrderController {

    /**
     * @description: 生成订单之前的数据确认和设置
     * @param weixinRequestBean
     * @return WeixinResponesBean<PreOrderVo>
     */
    @RequestMapping(path="/order/preOrder",method= RequestMethod.POST)
    public WeixinResponesBean<PreOrderVo> preOrder(@RequestBody WeixinRequestBean weixinRequestBean){

        return null;
    }

    /**
     * @description: 生成订单
     * @param weixinRequestBean
     * @return WeixinResponesBean<OrderVo>
     */
    @RequestMapping(path="/order/generateOrder",method= RequestMethod.POST)
    public WeixinResponesBean<OrderVo> generateOrder(@RequestBody WeixinRequestBean weixinRequestBean){

        return null;
    }

    /**
     * @description: 去支付
     * @param weixinRequestBean
     * @return WeixinResponesBean<OrderVo>
     */
    @RequestMapping(path="/order/payOrder",method= RequestMethod.POST)
    public WeixinResponesBean<PayOrderVo> payOrder(@RequestBody WeixinRequestBean weixinRequestBean){

        return null;
    }
}
