package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.RedisStaticKeys;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.edit.OtcUserCartEditMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import com.cm.order.center.server.vo.CartGoodsTypeVo;
import com.cm.order.center.server.vo.CartGooodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * 查询会员购物车结果
 */
@Service("queryCartResultLogic")
@Slf4j
public class QueryCartResultLogic implements ILogic<WeixinRequestBean, CartGoodsTypeVo> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private OtcUserCartEditMapper otcUserCartEditMapper;

    @Override
    public CartGoodsTypeVo exec(WeixinRequestBean weixinRequestBean) {
        CartGoodsTypeVo vo = new CartGoodsTypeVo();
        List<OtcUserCartPo> list = (List<OtcUserCartPo>) weixinRequestBean.getParameter().get("goodsList");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        list.forEach(temp ->{
            CartGooodsVo cartGooods =  new CartGooodsVo();
            cartGooods.setCartStatus(temp.getCartStatus());
            cartGooods.setCartDate(sdf.format(temp.getCartDate()));
            cartGooods.setCartSeq(temp.getCartSeq());
            cartGooods.setBuyCounts(temp.getBuyCounts());
            cartGooods.setAdditional(temp.getAdditional());
            cartGooods.setActivityPrice(temp.getActivityPrice());
            cartGooods.setGoodsCode(temp.getGoodsCode());
            cartGooods.setGoodsImg(temp.getGoodsImg());
            cartGooods.setGoodsName(temp.getGoodsName());
            cartGooods.setSelltype(temp.getSelltype());
            String[] prices = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.PRICE,weixinRequestBean.getBusinessCode(),temp.getGoodsCode())).split(",");
            cartGooods.setGoodsPrice(new BigDecimal(prices[0]));
        });
        return vo;
    }
}
