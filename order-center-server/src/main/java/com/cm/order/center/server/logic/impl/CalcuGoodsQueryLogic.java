package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.ser.OtcUserCartSerMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据会员勾选的商品列表进行支付金额计算
 */
@Service("calcuGoodsQueryLogic")
@Slf4j
public class CalcuGoodsQueryLogic implements ILogic<WeixinRequestBean,String> {

    @Resource
    private OtcUserCartSerMapper otcUserCartSerMapper;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        String cartSeqs = weixinRequestBean.getStringValue("cartSeqs");
        if(StringUtils.isBlank(cartSeqs)){
            return "请选择你需要结算的商品";
        }
        List<Long> cartSeqList = new ArrayList<>();
        for(String seq : cartSeqs.split(",")){
            cartSeqList.add(Long.valueOf(seq));
        }
        List<OtcUserCartPo> list = otcUserCartSerMapper.byUserCartSeqQuery(weixinRequestBean.getTokenBean().getUserId(), cartSeqList);
        if(CollectionUtils.isEmpty(list)){
            return "会员购物中没有添加商品";
        }
        List<String> activityCode = new ArrayList<>();
        list.forEach(temp ->{
            if(temp.getSelltype() == 2){
                activityCode.add(temp.getActivityCode());
            }
            if(temp.getSelltype() == 3){
                weixinRequestBean.getParameter().put("batchFlg",true);
            }
            if(temp.getSelltype() == 1){
                weixinRequestBean.getParameter().put("commonFlg",true);
            }
        });
        if(activityCode.size() > 0){
            weixinRequestBean.getParameter().put("activityCode",activityCode);
        }
        weixinRequestBean.getParameter().put("goodsList",list);
        return SystemContains.SUCCESS;
    }
}
