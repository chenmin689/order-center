package com.cm.order.center.server.services.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.order.center.dao.mapper.ser.OtcUserCartSerMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import com.cm.order.center.server.services.WeixinCartService;
import com.cm.order.center.server.vo.CartGoodsTypeVo;
import com.cm.order.center.server.vo.PayMoneyAmountVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class WeixinCartServiceImpl implements WeixinCartService {

    @Resource
    private OtcUserCartSerMapper otcUserCartSerMapper;

    @Resource
    private ILogic<WeixinRequestBean,String> checkActivityLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> checkGoodsStockLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> checkCartGoodsLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> toCartAddGoodsLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> updateCartGoodsCountLogic;

    @Resource
    private ILogic<WeixinRequestBean, Integer> delCartGoodsLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> queryUserCartGoodsLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> queryCheckActivityLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> queryCheckGoodsStockLogic;

    @Resource
    private ILogic<WeixinRequestBean,CartGoodsTypeVo> queryCartResultLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> calcuGoodsQueryLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> calcuUserDiscountLogic;

    @Resource
    private ILogic<WeixinRequestBean,String> calcuSellGoodsLogic;

    @Resource
    private ILogic<WeixinRequestBean,PayMoneyAmountVo> calculateResultLogic;

    @Override
    public WeixinResponesBean<String> toCartAddGoods(WeixinRequestBean weixinRequestBean) {
        try {
            //活动有效期检查
            String result = checkActivityLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //验证库存
            result = checkGoodsStockLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //验证会员购物中是否有此商品
            result = checkCartGoodsLogic.exec(weixinRequestBean);
            if(result.equals(SystemContains.STEP_ONE)){
                return new WeixinResponesBean<>("商品加车成功");
            }
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //向会员购物车中增加商品
            result = toCartAddGoodsLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }
            return new WeixinResponesBean<>("商品加车成功");
        }catch (Exception e) {
            log.error("向会员购物车中添加商品,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }

    @Override
    public WeixinResponesBean<CartGoodsTypeVo> queryCartGoods(WeixinRequestBean weixinRequestBean) {
        try {
            //查询会员购物车商品信息
            String result = queryUserCartGoodsLogic.exec(weixinRequestBean);
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

            //组装数据返回
            CartGoodsTypeVo vo = queryCartResultLogic.exec(weixinRequestBean);
            if(vo == null){
                return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
            }
            return new WeixinResponesBean<>(vo);
        }catch (Exception e) {
            log.error("分页查询会员加入购物车中的商品集合,异常：",e);
            return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
        }
    }

    @Override
    public WeixinResponesBean<String> editCartGoods(WeixinRequestBean weixinRequestBean) {
        try {
            OtcUserCartPo po = otcUserCartSerMapper.byPrimaryKeyPo(weixinRequestBean.getLongValue("cartSeq"));
            if(po == null){
                return new WeixinResponesBean<>(1,"没有查询到历史数据");
            }
            weixinRequestBean.setParameter("buyType",po.getSelltype());
            weixinRequestBean.setParameter("goodsCode",po.getGoodsCode());
            if(StringUtils.isNotBlank(po.getActivityCode())) {
                weixinRequestBean.setParameter("activityCode",po.getActivityCode());
            }

            //活动有效期检查
            String result = checkActivityLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //验证库存
            result = checkGoodsStockLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }

            //修改购物车中商品的购买数量
            result = updateCartGoodsCountLogic.exec(weixinRequestBean);
            if(!result.equals(SystemContains.SUCCESS)){
                return new WeixinResponesBean<>(1,result);
            }
            return new WeixinResponesBean<>("商品购买数量增加成功");
        }catch (Exception e) {
            log.error("修改会员购物车中商品的购买数量,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }

    @Override
    public WeixinResponesBean<Integer> delCartGoods(WeixinRequestBean weixinRequestBean) {
        try {
            int result = delCartGoodsLogic.exec(weixinRequestBean);
            if(result == 0){
                return new WeixinResponesBean<>(1,"购物车商品删除失败");
            }
            return new WeixinResponesBean<>(result);
        }catch (Exception e) {
            log.error("删除会员购物车中商品,异常：",e);
        }
        return new WeixinResponesBean<>(0);
    }

    @Override
    public WeixinResponesBean<PayMoneyAmountVo> calculate(WeixinRequestBean weixinRequestBean) {
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

            //组装信息返回
            PayMoneyAmountVo vo = calculateResultLogic.exec(weixinRequestBean);
            if(vo == null){
                return new WeixinResponesBean<>(1,"支付金额计算失败");
            }
            return new WeixinResponesBean<>(vo);
        }catch (Exception e) {
            log.error("会员想要购物商品需要支付的总金额计算,异常：",e);
        }
        return new WeixinResponesBean<>(1,"系统异常，请稍后重试！");
    }
}