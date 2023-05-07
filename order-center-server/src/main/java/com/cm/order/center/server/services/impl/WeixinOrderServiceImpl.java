package com.cm.order.center.server.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.order.center.server.services.WeixinOrderService;
import com.cm.order.center.server.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WeixinOrderServiceImpl implements WeixinOrderService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ILogic<WeixinRequestBean,String> queryCheckActivityLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> queryCheckGoodsStockLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> calcuGoodsQueryLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> calcuUserDiscountLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> calcuSellGoodsLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> calcuBatchGoodsLogic;

    @Resource
    private ILogic<WeixinRequestBean,PayMoneyAmountVo> calculateResultLogic;

    @Resource
    private ILogic<WeixinRequestBean,OrderVo> createOrderNoLogic;

    @Override
    public WeixinResponesBean<PreOrderVo> preOrder(WeixinRequestBean weixinRequestBean) {
        try {
            //查询会员下单商品
            String result = calcuGoodsQueryLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //会员购物车中商品活动有效期检查
            result = queryCheckActivityLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //验证库存
            result = queryCheckGoodsStockLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //查询会员折扣级别
            result = calcuUserDiscountLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //计算支付金额
            result = calcuSellGoodsLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //运费计算
            result = calcuBatchGoodsLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //组装信息返回
            PayMoneyAmountVo vo = calculateResultLogic.exec(weixinRequestBean);
            if(vo == null){
                return new WeixinResponesBean<>(1,"支付金额计算失败");
            }
            return new WeixinResponesBean<>(new PreOrderVo(vo.getRealPayMoney(),vo.getOrderMoney(),vo.getDiscountMoney(),vo.getPostMoney()));
        }catch (Exception e) {
            log.error("生成订单之前的数据确认和设置,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }

    @Override
    public WeixinResponesBean<OrderVo> generateOrder(WeixinRequestBean weixinRequestBean) {

        try {
            //查询会员下单商品
            String result = calcuGoodsQueryLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //会员购物车中商品活动有效期检查
            result = queryCheckActivityLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //验证库存
            result = queryCheckGoodsStockLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //查询会员折扣级别
            result = calcuUserDiscountLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //计算支付金额
            result = calcuSellGoodsLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //运费计算
            result = calcuBatchGoodsLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //组装信息返回
            OrderVo vo = createOrderNoLogic.exec(weixinRequestBean);
            if(vo == null){
                return new WeixinResponesBean<>(1,"支付金额计算失败");
            }
            return new WeixinResponesBean<>(vo);
        }catch (Exception e) {
            log.error("生成订单之前的数据确认和设置,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }


    @Override
    public WeixinResponesBean<PayOrderVo> payOrder(WeixinRequestBean weixinRequestBean) {
        return null;
    }
}
