package com.cm.order.center.server.controller;

import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.architecture.commons.weixin.WeixinResponesBean;
import com.cm.order.center.server.services.WeixinCartService;
import com.cm.order.center.server.vo.CartGooodsVo;
import com.cm.order.center.server.vo.PayMoneyCalculateVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小程序端购物车接口
 * @author chenmin
 */
@RestController
@RequestMapping("order")
public class WeixinCartController {

    @Resource
    private WeixinCartService weixinCartService;

    /**
     * 向会员购物车中添加商品
     * @param weixinRequestBean
     * @return WeixinResponesBean<String>
     */
    @RequestMapping(path="/cart/addGoods",method= RequestMethod.POST)
    public WeixinResponesBean<String> toCartAddGoods(@RequestBody WeixinRequestBean weixinRequestBean) {

        return weixinCartService.toCartAddGoods(weixinRequestBean);
    }

    /**
     * 分页查询会员加入购物车中的商品集合
     * @param weixinRequestBean
     * @return WeixinResponesBean<List<CartGooodsVo>>
     */
    @RequestMapping(path="/cart/queryCartGoods",method= RequestMethod.POST)
    public WeixinResponesBean<List<CartGooodsVo>> queryCartGoods(@RequestBody WeixinRequestBean weixinRequestBean) {

        return weixinCartService.queryCartGoods(weixinRequestBean);
    }

    /**
     * 修改会员购物车中商品的购买数量
     * @param weixinRequestBean
     * @return WeixinResponesBean<String>
     */
    @RequestMapping(path="/cart/addBuyCounts",method= RequestMethod.POST)
    public WeixinResponesBean<String> addBuyCounts(@RequestBody WeixinRequestBean weixinRequestBean) {

        return weixinCartService.addBuyCounts(weixinRequestBean);
    }

    /**
     * 删除会员购物车中商品
     * @param weixinRequestBean
     * @return WeixinResponesBean<Integer>
     */
    @RequestMapping(path="/cart/delCartGoods",method= RequestMethod.POST)
    public WeixinResponesBean<Integer> delCartGoods(@RequestBody WeixinRequestBean weixinRequestBean) {

        return weixinCartService.delCartGoods(weixinRequestBean);
    }

    /**
     * 会员想要购物商品需要支付的总金额计算
     * @param weixinRequestBean
     * @return WeixinResponesBean<PayMoneyCalculateVo>
     */
    @RequestMapping(path="/cart/calculate",method= RequestMethod.POST)
    public WeixinResponesBean<PayMoneyCalculateVo> calculate(@RequestBody WeixinRequestBean weixinRequestBean) {

        return weixinCartService.calculate(weixinRequestBean);
    }
}
