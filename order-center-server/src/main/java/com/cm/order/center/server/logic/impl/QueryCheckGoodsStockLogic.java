package com.cm.order.center.server.logic.impl;

import com.alibaba.fastjson.JSONObject;
import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.RedisStaticKeys;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.edit.OtcUserCartEditMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 验证会员已经加车商品是否有足够多的库存
 */
@Service("queryCheckGoodsStockLogic")
@Slf4j
public class QueryCheckGoodsStockLogic implements ILogic<WeixinRequestBean,String> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private OtcUserCartEditMapper otcUserCartEditMapper;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        List<OtcUserCartPo> list = (List<OtcUserCartPo>) weixinRequestBean.getParameter().get("goodsList");
        Map<String,Integer> activityMap = new HashMap<>();
        if(weixinRequestBean.getParameter().containsKey("activityCode")){
            activityMap.putAll((Map<? extends String, ? extends Integer>) weixinRequestBean.getParameter().get("activityCode"));
        }
        for(OtcUserCartPo cartGoods : list){
            boolean isEdit = false;
            int buyType = cartGoods.getSelltype();//验证活动是否有效  销售类型：1，普通销售；2，活动销售；3，批发销售
            Integer goodsCode = cartGoods.getGoodsCode();
            Integer buyCount = cartGoods.getBuyCounts();
            if(buyType == 2){
                String stockSell = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.STOCK_SELL,weixinRequestBean.getBusinessCode(),goodsCode));
                if(StringUtils.isBlank(stockSell) || Integer.valueOf(stockSell) < 1){
                    cartGoods.setCartStatus(4);
                    isEdit = true;
                }
                if(!activityMap.containsKey(cartGoods.getActivityCode()) || activityMap.get(cartGoods.getActivityCode()) == 0){
                    cartGoods.setCartStatus(2);
                    isEdit = true;
                }
            }else {
                String stockValid = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.STOCK_VALID, weixinRequestBean.getBusinessCode(), goodsCode));
                if (StringUtils.isBlank(stockValid) || Integer.valueOf(stockValid) < buyCount) {
                    cartGoods.setCartStatus(4);
                    isEdit = true;
                }
            }
            if(buyType == 3){
                String goodsInfo = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.GOODS,weixinRequestBean.getBusinessCode(),goodsCode));
                JSONObject jsonObject = JSONObject.parseObject(goodsInfo);
                if(!jsonObject.containsKey("wholesaleCount") || jsonObject.getInteger("wholesaleCount") == 0){
                    cartGoods.setCartStatus(3);
                    isEdit = true;
                }
            }

            if(isEdit){
                cartGoods.setUpdateTime(new Date());
                otcUserCartEditMapper.editEntity(cartGoods);
            }
        }
        return SystemContains.SUCCESS;
    }
}
