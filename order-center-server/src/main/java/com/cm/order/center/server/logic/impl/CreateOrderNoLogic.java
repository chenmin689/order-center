package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.edit.OtcOrderDetailEditMapper;
import com.cm.order.center.dao.mapper.edit.OtcOrderEditMapper;
import com.cm.order.center.dao.po.OtcOrderDetailPo;
import com.cm.order.center.dao.po.OtcOrderPo;
import com.cm.order.center.dao.po.OtcUserCartPo;
import com.cm.order.center.server.vo.OrderVo;
import com.cm.order.center.server.vo.PayMoneyCalculateVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建订单
 */
@Service("createOrderNoLogic")
@Slf4j
public class CreateOrderNoLogic implements ILogic<WeixinRequestBean,OrderVo> {

    @Resource
    private OtcOrderEditMapper otcOrderEditMapper;

    @Resource
    private OtcOrderDetailEditMapper otcOrderDetailEditMapper;

    @Override
    @Transactional
    public OrderVo exec(WeixinRequestBean weixinRequestBean) {
        BigDecimal realPayMoney = new BigDecimal(0);
        BigDecimal orderMoney = new BigDecimal(0);
        BigDecimal discountMoney = new BigDecimal(0);
        if(weixinRequestBean.getCheckKey("commonPayMoney")){
            PayMoneyCalculateVo comm = (PayMoneyCalculateVo) weixinRequestBean.getParameter().get("commonPayMoney");
            realPayMoney = realPayMoney.add(comm.getPayMoney());
            orderMoney = orderMoney.add(comm.getOrderMoney());
            discountMoney = discountMoney.add(comm.getPreferMoney());
        }
        if(weixinRequestBean.getCheckKey("sellPayMoney")){
            PayMoneyCalculateVo sell = (PayMoneyCalculateVo) weixinRequestBean.getParameter().get("sellPayMoney");
            realPayMoney = realPayMoney.add(sell.getPayMoney());
            orderMoney = orderMoney.add(sell.getOrderMoney());
            discountMoney = discountMoney.add(sell.getPreferMoney());
        }
        BigDecimal postCost = new BigDecimal(0);
        if(weixinRequestBean.getCheckKey("postCost")) {
            postCost = weixinRequestBean.getBigDecimalValue("postCost");
        }

        String orderNo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+String.valueOf(weixinRequestBean.getTokenBean().getUserId()).substring(0,3);

        OtcOrderPo orderPo = new OtcOrderPo();
        orderPo.setOrderNo(orderNo);
        orderPo.setOrderMoney(orderMoney);
        orderPo.setBusinessCode(weixinRequestBean.getBusinessCode());
        orderPo.setOrderType(1);
        orderPo.setOrderStatus(10);
        orderPo.setDiscountMoney(discountMoney);
        orderPo.setDiscountRate(orderMoney.subtract(discountMoney).divide(orderMoney,2,BigDecimal.ROUND_HALF_UP));
        orderPo.setPostMoney(postCost);
        orderPo.setPayMoney(realPayMoney.add(postCost));
        orderPo.setPayModel(1);
        orderPo.setSalesman(1);
        otcOrderEditMapper.save(orderPo);

        List<OtcUserCartPo> list = (List<OtcUserCartPo>) weixinRequestBean.getParameter().get("goodsList");
        List<OtcOrderDetailPo> saveList = new ArrayList<>();
        OtcOrderDetailPo child;
        for(OtcUserCartPo cart : list){
            child = new OtcOrderDetailPo();
            child.setOrderNo(orderNo);
            child.setChildOrderNo("0000");
            child.setSellType(cart.getSelltype());
            child.setBatchPrice(new BigDecimal(0));
            child.setGoodsCode(cart.getGoodsCode());
            child.setGoodsName(cart.getGoodsName());
            child.setGoodsImg(cart.getGoodsImg());
            child.setGoodsPrice(cart.getGoodsPrice());
            child.setGoodsCount(cart.getBuyCounts());

            if(StringUtils.isNotBlank(cart.getActivityCode()) && !"0000".equals(cart.getActivityCode())){
                child.setDiscountMoeny(new BigDecimal(0));
                child.setDiscountRate(new BigDecimal(0));
            }else{
                child.setDiscountMoeny(new BigDecimal(0));
                child.setDiscountRate(new BigDecimal(0));
            }
            saveList.add(child);
        }
        otcOrderDetailEditMapper.saveList(saveList);
        OrderVo vo = new OrderVo();
        vo.setOrderNo(orderNo);
        vo.setRealPayMoney(orderPo.getPayMoney());
        return vo;
    }
}
