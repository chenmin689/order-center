package com.cm.order.center.server.services;

import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.order.center.server.vo.CartGoodsTypeVo;
import com.cm.order.center.server.vo.PayMoneyAmountVo;

/**
 * 小程序端购物车接口
 * @author chenmin
 */
public interface WeixinCartService{


    /**
     * 向会员购物车中添加商品
     * @param weixinRequestBean
     * @return WeixinResponesBean<String>
     */
    public WeixinResponesBean<String> toCartAddGoods(WeixinRequestBean weixinRequestBean);

    /**
     * 分页查询会员加入购物车中的商品集合
     * @param weixinRequestBean
     * @return WeixinResponesBean<List<CartGooodsVo>>
     */
    public WeixinResponesBean<CartGoodsTypeVo> queryCartGoods(WeixinRequestBean weixinRequestBean);

    /**
     * 修改会员购物车中商品的购买数量
     * @param weixinRequestBean
     * @return WeixinResponesBean<String>
     */
    public WeixinResponesBean<String> editCartGoods(WeixinRequestBean weixinRequestBean);

    /**
     * 删除会员购物车中商品
     * @param weixinRequestBean
     * @return WeixinResponesBean<Integer>
     */
    public WeixinResponesBean<Integer> delCartGoods(WeixinRequestBean weixinRequestBean);

    /**
     * 购物车预计算接口
     * @param weixinRequestBean
     * @return WeixinResponesBean<PayMoneyCalculateVo>
     */
    public WeixinResponesBean<PayMoneyAmountVo> calculate(WeixinRequestBean weixinRequestBean);

}
