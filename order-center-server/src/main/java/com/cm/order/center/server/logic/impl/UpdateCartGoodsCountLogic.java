package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.edit.OtcUserCartEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcUserCartSerMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 修改购物车中商品的购买数量
 */
@Service("updateCartGoodsCountLogic")
@Slf4j
public class UpdateCartGoodsCountLogic implements ILogic<WeixinRequestBean,String> {

    @Resource
    private OtcUserCartEditMapper otcUserCartEditMapper;

    @Resource
    private OtcUserCartSerMapper otcUserCartSerMapper;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {

        OtcUserCartPo po = otcUserCartSerMapper.byPrimaryKeyPo(weixinRequestBean.getLongValue("cartSeq"));
        if(po.getUserId() != weixinRequestBean.getTokenBean().getUserId()){
            return "库存修改失败，只能修改自己的购买数量";
        }
        if(po == null){
            return "库存修改失败，购物车中没有此商品";
        }
        po.setBuyCounts(weixinRequestBean.getIntegerValue("buyCount"));
        if(weixinRequestBean.isNotNull("additional")){
            po.setAdditional(weixinRequestBean.getStringValue("additional"));
        }
        po.setUpdateTime(new Date());
        otcUserCartEditMapper.editEntity(po);
        return SystemContains.SUCCESS;
    }
}
