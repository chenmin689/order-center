package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.edit.OtcUserCartEditMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("toCartAddGoodsLogic")
@Slf4j
public class ToCartAddGoodsLogic  implements ILogic<WeixinRequestBean,String> {

    @Resource
    private OtcUserCartEditMapper otcUserCartEditMapper;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        int buyType = weixinRequestBean.getIntegerValue("buyType");//验证活动是否有效  销售类型：1，普通销售；2，活动销售；3，批发销售
        //Integer userId = weixinRequestBean.getTokenBean().getUserId(); //TODO
        Integer userId = 1;
        OtcUserCartPo po = new OtcUserCartPo();
        po.setUserId(userId);
        po.setBusinessCode(weixinRequestBean.getBusinessCode());
        po.setGoodsCode(weixinRequestBean.getIntegerValue("goodsCode"));
        po.setSelltype(buyType);
        po.setCartDate(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())));
        po.setBuyCounts(weixinRequestBean.getIntegerValue("buyCount"));
        po.setCartStatus(1);
        if(buyType == 2){
            po.setActivityCode(weixinRequestBean.getStringValue("activityCode"));
            po.setActivityPrice(weixinRequestBean.getBigDecimalValue("activityPrice"));
        }else{
            po.setActivityPrice(new BigDecimal(0));
        }
        if(weixinRequestBean.isNotNull("additional")) {
            po.setAdditional(weixinRequestBean.getStringValue("additional"));
        }
        po.setCreateTime(new Date());
        po.setUpdateTime(po.getCreateTime());
        po.setGoodsName(weixinRequestBean.getStringValue("goodsName"));
        po.setGoodsImg(weixinRequestBean.getStringValue("goodsImg"));
        boolean flag = otcUserCartEditMapper.save(po);
        if(!flag){
            return "商品加车失败";
        }
        return SystemContains.SUCCESS;
    }
}
