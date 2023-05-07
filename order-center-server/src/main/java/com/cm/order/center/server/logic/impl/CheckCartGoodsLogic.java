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

@Service("checkCartGoodsLogic")
@Slf4j
public class CheckCartGoodsLogic implements ILogic<WeixinRequestBean,String> {

    @Resource
    private OtcUserCartSerMapper otcUserCartSerMapper;

    @Resource
    private OtcUserCartEditMapper otcUserCartEditMapper;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        int buyType = weixinRequestBean.getIntegerValue("buyType");
        //验证活动是否有效  销售类型：1，普通销售；2，活动销售；3，批发销售
        Integer goodsCode = weixinRequestBean.getIntegerValue("goodsCode");
        //Integer userId = weixinRequestBean.getTokenBean().getUserId(); //TODO
        Integer userId = 1;
        OtcUserCartPo po = new OtcUserCartPo();
        po.setUserId(userId);
        po.setBusinessCode(weixinRequestBean.getBusinessCode());
        po.setGoodsCode(goodsCode);
        po = otcUserCartSerMapper.byWhereQueryPo(po);
        if(po != null){
            if(po.getSelltype() == buyType){
                po.setBuyCounts(weixinRequestBean.getIntegerValue("buyCount"));
            }else{
                po.setBuyCounts(weixinRequestBean.getIntegerValue("buyCount"));
                po.setSelltype(buyType);
            }
            po.setUpdateTime(new Date());
            otcUserCartEditMapper.editEntity(po);
            return SystemContains.STEP_ONE;
        }

        return SystemContains.SUCCESS;
    }
}
