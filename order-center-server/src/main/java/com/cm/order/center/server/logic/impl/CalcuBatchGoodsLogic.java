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
 * 批发商品活动计算
 */
@Service("calcuBatchGoodsLogic")
@Slf4j
public class CalcuBatchGoodsLogic implements ILogic<WeixinRequestBean,String> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        if(weixinRequestBean.getCheckKey("commonFlg")){
            List<OtcUserCartPo> list = (List<OtcUserCartPo>) weixinRequestBean.getParameter().get("goodsList");
            BigDecimal batchPayMoney = new BigDecimal(0.00);
            for(OtcUserCartPo po : list){
                if(po.getSelltype() != 3){
                    continue;
                }
                String[] prices = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.PRICE,weixinRequestBean.getBusinessCode(),po.getGoodsCode())).split(",");
                batchPayMoney = batchPayMoney.add(new BigDecimal(prices[1]).multiply(new BigDecimal(po.getBuyCounts())));
            }
            if(batchPayMoney.compareTo(new BigDecimal(0))>0){
                PayMoneyCalculateVo vo = new PayMoneyCalculateVo();
                vo.setSelltype(2);
                vo.setPayModel(1);
                vo.setOrderMoney(batchPayMoney);
                vo.setDiscountRate(new BigDecimal(1));
                vo.setDiscountMoney(batchPayMoney);
                vo.setPreferMoney(new BigDecimal(0));
                vo.setPostMoney(new BigDecimal(0));//TODO
                vo.setPayMoney(vo.getDiscountMoney().add(vo.getPostMoney()));
                weixinRequestBean.getParameter().put("batchPayMoney",vo);
            }
        }
        return SystemContains.SUCCESS;
    }
}
