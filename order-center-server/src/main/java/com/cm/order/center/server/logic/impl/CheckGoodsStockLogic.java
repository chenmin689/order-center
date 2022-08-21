package com.cm.order.center.server.logic.impl;

import com.alibaba.fastjson.JSONObject;
import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.RedisStaticKeys;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service("checkGoodsStockLogic")
@Slf4j
public class CheckGoodsStockLogic implements ILogic<WeixinRequestBean,String> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        int buyType = weixinRequestBean.getIntegerValue("buyType");
        //验证活动是否有效  销售类型：1，普通销售；2，活动销售；3，批发销售
        Integer goodsCode = weixinRequestBean.getIntegerValue("goodsCode");
        if(buyType == 2){
            String stockSell = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.STOCK_SELL,weixinRequestBean.getBusinessCode(),goodsCode));
            if(StringUtils.isBlank(stockSell) || Integer.valueOf(stockSell) < 1){
                return "商品加车失败，此商品没有足够的活动库存";
            }
            return SystemContains.SUCCESS;
        }
        Integer buyCount = weixinRequestBean.getIntegerValue("buyCount");
        String goodsInfo = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.GOODS,weixinRequestBean.getBusinessCode(),goodsCode));
        JSONObject jsonObject = JSONObject.parseObject(goodsInfo);
        if(buyType == 3){
            int buyStock = jsonObject.getInteger("wholesaleCount");
            if(buyCount<buyStock){
                buyCount = buyStock;
            }
            weixinRequestBean.getParameter().put("buyCount",buyCount);
            weixinRequestBean.getParameter().put("wholesalePrice",jsonObject.getBigDecimal("wholesalePrice"));
        }
        weixinRequestBean.getParameter().put("goodsName",jsonObject.getString("goodsName"));
        weixinRequestBean.getParameter().put("goodsImg",jsonObject.getString("goodsImg"));
        String stockValid = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.STOCK_VALID,weixinRequestBean.getBusinessCode(),goodsCode));
        if(StringUtils.isBlank(stockValid) || Integer.valueOf(stockValid) < buyCount){
            return "商品加车失败，此商品没有足够的可售库存";
        }
        return SystemContains.SUCCESS;
    }
}
