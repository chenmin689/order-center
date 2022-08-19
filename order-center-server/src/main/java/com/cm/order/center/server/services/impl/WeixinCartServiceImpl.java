package com.cm.order.center.server.services.impl;

import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.order.center.server.services.WeixinCartService;
import com.cm.order.center.server.vo.CartGooodsVo;
import com.cm.order.center.server.vo.PayMoneyCalculateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class WeixinCartServiceImpl implements WeixinCartService {

    @Override
    public WeixinResponesBean<String> toCartAddGoods(WeixinRequestBean weixinRequestBean) {
        try {
            //验证活动是否有效

            //验证库存

            //验证会员购物中是否有此商品

            //向会员购物车中增加商品

        }catch (Exception e) {
            log.error("向会员购物车中添加商品,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }

    @Override
    public WeixinResponesBean<List<CartGooodsVo>> queryCartGoods(WeixinRequestBean weixinRequestBean) {
        try {
            //查询商品信息

            //验证活动有效期

            //验证库存

            //组装数据返回
        }catch (Exception e) {
            log.error("分页查询会员加入购物车中的商品集合,异常：",e);
        }
        return new WeixinResponesBean<>(new ArrayList<>());
    }

    @Override
    public WeixinResponesBean<String> addBuyCounts(WeixinRequestBean weixinRequestBean) {
        try {
            //查询加车详细信息

            //验证活动有效期

            //验证库存

            //增加购买数量
        }catch (Exception e) {
            log.error("修改会员购物车中商品的购买数量,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }

    @Override
    public WeixinResponesBean<Integer> delCartGoods(WeixinRequestBean weixinRequestBean) {
        try {
            //修改加车状态
        }catch (Exception e) {
            log.error("删除会员购物车中商品,异常：",e);
        }
        return new WeixinResponesBean<>(0);
    }

    @Override
    public WeixinResponesBean<PayMoneyCalculateVo> calculate(WeixinRequestBean weixinRequestBean) {
        try {
            //查询加车商品详细信息

            //验证活动有效期

            //验证库存

            //查询商品信息

            //查询会员折扣级别

            //计算支付金额

            //组装信息返回
        }catch (Exception e) {
            log.error("会员想要购物商品需要支付的总金额计算,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }
}
