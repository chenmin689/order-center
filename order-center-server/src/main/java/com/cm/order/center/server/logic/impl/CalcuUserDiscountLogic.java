package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.RedisStaticKeys;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.po.OtcUserCartPo;
import com.cm.order.center.server.vo.PayMoneyCalculateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
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
                PayMoneyCalculateVo vo = new PayMoneyCalculateVo();
                vo.setSelltype(1);
                vo.setPayModel(1);
                vo.setOrderMoney(commonPayMoney);
                vo.setDiscountRate(new BigDecimal(1));
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
