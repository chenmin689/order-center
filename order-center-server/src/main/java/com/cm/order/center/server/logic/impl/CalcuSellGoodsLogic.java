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
 * 活动商品支付金额计算
 */
@Service("calcuSellGoodsLogic")
@Slf4j
public class CalcuSellGoodsLogic implements ILogic<WeixinRequestBean,String> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        if(weixinRequestBean.getCheckKey("commonFlg")){
            List<OtcUserCartPo> list = (List<OtcUserCartPo>) weixinRequestBean.getParameter().get("goodsList");
            BigDecimal sellPayMoney = new BigDecimal(0.00);
            BigDecimal commonPayMoney = new BigDecimal(0.00);
            for(OtcUserCartPo po : list){
                if(po.getSelltype() != 2){
                    continue;
                }
                String[] prices = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.PRICE,weixinRequestBean.getBusinessCode(),po.getGoodsCode())).split(",");
                sellPayMoney = sellPayMoney.add(new BigDecimal(prices[0]).multiply(new BigDecimal(po.getBuyCounts())));
                commonPayMoney = commonPayMoney.add(po.getActivityPrice().multiply(new BigDecimal(po.getBuyCounts())));
                po.setGoodsPrice(new BigDecimal(prices[0]));
            }
            if(sellPayMoney.compareTo(new BigDecimal(0))>0){
                PayMoneyCalculateVo vo = new PayMoneyCalculateVo();
                vo.setSelltype(2);
                vo.setPayModel(1);
                vo.setOrderMoney(commonPayMoney);
                vo.setDiscountRate(new BigDecimal(1));
                vo.setDiscountMoney(sellPayMoney);
                vo.setPreferMoney(vo.getOrderMoney().subtract(vo.getDiscountMoney()));
                vo.setPostMoney(new BigDecimal(6));//TODO
                vo.setPayMoney(vo.getDiscountMoney().add(vo.getPostMoney()));
                weixinRequestBean.getParameter().put("sellPayMoney",vo);
            }
        }
        return SystemContains.SUCCESS;
    }
}
