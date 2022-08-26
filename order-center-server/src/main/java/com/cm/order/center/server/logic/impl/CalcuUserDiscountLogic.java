package com.cm.order.center.server.logic.impl;

import com.alibaba.fastjson.JSONObject;
import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.rpc.RpcRequestBean;
import com.cm.architecture.commons.rpc.RpcResponesBean;
import com.cm.architecture.commons.utils.RedisStaticKeys;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.po.OtcUserCartPo;
import com.cm.order.center.server.nacos.UsercenterClients;
import com.cm.order.center.server.vo.PayMoneyCalculateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 普通商品折扣计算
 */
@Service("calcuUserDiscountLogic")
@Slf4j
public class CalcuUserDiscountLogic implements ILogic<WeixinRequestBean,String> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UsercenterClients usercenterClients;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        if(weixinRequestBean.getCheckKey("commonFlg")){
            List<OtcUserCartPo> list = (List<OtcUserCartPo>) weixinRequestBean.getParameter().get("goodsList");
            BigDecimal commonPayMoney = new BigDecimal(0.00);
            for(OtcUserCartPo po : list){
                if(po.getSelltype() != 1){
                    continue;
                }
                String[] prices = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.PRICE,weixinRequestBean.getBusinessCode(),po.getGoodsCode())).split(",");
                commonPayMoney = commonPayMoney.add(new BigDecimal(prices[0]).multiply(new BigDecimal(po.getBuyCounts())));
            }
            if(commonPayMoney.compareTo(new BigDecimal(0))>0){
                RpcRequestBean bean = new  RpcRequestBean();
                bean.setBusinessCode(weixinRequestBean.getBusinessCode());
                JSONObject req = new JSONObject();
                req.put("userId",weixinRequestBean.getTokenBean().getUserId());
                bean.setData(req);
                RpcResponesBean rpcResponesBean = usercenterClients.queryUserDiscountLevel(bean);
                if(rpcResponesBean == null){
                    return "计算实际支付金额失败";
                }
                String level = rpcResponesBean.getData().toString();
                PayMoneyCalculateVo vo = new PayMoneyCalculateVo();
                vo.setSelltype(1);
                vo.setPayModel(1);
                vo.setOrderMoney(commonPayMoney);
                vo.setDiscountRate(new BigDecimal(level));
                vo.setDiscountMoney(vo.getOrderMoney().multiply(vo.getDiscountRate()));
                vo.setPreferMoney(vo.getOrderMoney().subtract(vo.getDiscountMoney()));
                vo.setPostMoney(new BigDecimal(6));//TODO
                vo.setPayMoney(vo.getDiscountMoney().add(vo.getPostMoney()));
                weixinRequestBean.getParameter().put("commonPayMoney",vo);
            }
        }
        return SystemContains.SUCCESS;
    }
}
