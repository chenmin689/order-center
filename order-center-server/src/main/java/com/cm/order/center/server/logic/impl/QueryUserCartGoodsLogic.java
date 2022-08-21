package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.ser.OtcUserCartSerMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询会员购物车添加的商品
 */
@Service("queryUserCartGoodsLogic")
@Slf4j
public class QueryUserCartGoodsLogic implements ILogic<WeixinRequestBean,String> {

    @Resource
    private OtcUserCartSerMapper otcUserCartSerMapper;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        OtcUserCartPo po = new OtcUserCartPo();
        po.setBusinessCode(weixinRequestBean.getBusinessCode());
        po.setUserId(weixinRequestBean.getTokenBean().getUserId());
        List<OtcUserCartPo> list = otcUserCartSerMapper.byWhereQueryList(po);
        if(CollectionUtils.isEmpty(list)){
            return "会员购物中没有添加商品";
        }
        List<String> activityCode = new ArrayList<>();
        list.forEach(temp ->{
            if(temp.getSelltype() == 2){
                activityCode.add(temp.getActivityCode());
            }
        });
        if(activityCode.size() > 0){
            weixinRequestBean.getParameter().put("activityCode",activityCode);
        }
        weixinRequestBean.getParameter().put("goodsList",list);
        return SystemContains.SUCCESS;
    }
}
