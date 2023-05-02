package com.cm.order.center.server.controller;

import com.cm.architecture.commons.beans.ClientRequestBean;
import com.cm.architecture.commons.beans.ClientResponesBean;
import com.cm.architecture.commons.select.SelectNode;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.architecture.jdbc.entity.ResultFrontendVo;
import com.cm.order.center.server.services.PostCompanyCostService;
import com.cm.order.center.server.services.WeixinOrderService;
import com.cm.order.center.server.vo.OrderVo;
import com.cm.order.center.server.vo.PayMoneyAmountVo;
import com.cm.order.center.server.vo.PayOrderVo;
import com.cm.order.center.server.vo.PreOrderVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * description: 微信小程序下单控制器
 * @author chenmin
 * @version 1.0.0
 * @date 2022/09/03 10:31:43
 */
@RestController
@RequestMapping("weixin")
public class WeixinOrderController {

    @Resource
    private WeixinOrderService weixinOrderService;

    @Autowired
    private PostCompanyCostService postCompanyCostService;

    /**
     * 物流公司查询
     * @param weixinRequestBean
     * @return ClientResponesBean<List<SelectNode>>
     */
    @RequestMapping(path="/order/postCompany",method=RequestMethod.POST)
    public ClientResponesBean<List<SelectNode>> postCompany(@RequestBody WeixinRequestBean weixinRequestBean) {
        return new ClientResponesBean(postCompanyCostService.select());
    }

    /**
     * @description: 生成订单之前的数据确认和设置
     * @param weixinRequestBean
     * @return WeixinResponesBean<PreOrderVo>
     */
    @RequestMapping(path="/order/preOrder",method= RequestMethod.POST)
    public WeixinResponesBean<PreOrderVo> preOrder(@RequestBody WeixinRequestBean weixinRequestBean){

        return weixinOrderService.preOrder(weixinRequestBean);
    }

    /**
     * @description: 生成订单
     * @param weixinRequestBean
     * @return WeixinResponesBean<OrderVo>
     */
    @RequestMapping(path="/order/submitOrder",method= RequestMethod.POST)
    public WeixinResponesBean<OrderVo> submitOrder(@RequestBody WeixinRequestBean weixinRequestBean){

        return weixinOrderService.generateOrder(weixinRequestBean);
    }

    /**
     * @description: 去支付
     * @param weixinRequestBean
     * @return WeixinResponesBean<OrderVo>
     */
    @RequestMapping(path="/order/payOrder",method= RequestMethod.POST)
    public WeixinResponesBean<PayOrderVo> payOrder(@RequestBody WeixinRequestBean weixinRequestBean){

        return weixinOrderService.payOrder(weixinRequestBean);
    }
}
