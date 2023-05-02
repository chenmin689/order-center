package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.ser.OtcCityPostCostSerMapper;
import com.cm.order.center.dao.mapper.ser.OtcPostCompanyCostSerMapper;
import com.cm.order.center.dao.po.OtcCityPostCostPo;
import com.cm.order.center.dao.po.OtcPostCompanyCostPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 根据会员勾选的商品列表进行支付金额计算
 */
@Service("calcuGoodsQueryLogic")
@Slf4j
public class PostCostCalcuLogic  implements ILogic<WeixinRequestBean,String> {

    @Resource
    private OtcCityPostCostSerMapper otcCityPostCosSerMapper;

    @Resource
    private OtcPostCompanyCostSerMapper otcPostCompanyCostSerMapper;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        if(weixinRequestBean.isNotNull("province") && weixinRequestBean.isNotNull("city")){
            BigDecimal postCost = new BigDecimal(0.00);
            OtcCityPostCostPo cityPostCost = new OtcCityPostCostPo();
            cityPostCost.setProvinceCode(weixinRequestBean.getIntegerValue("province"));
            cityPostCost.setCityCode(weixinRequestBean.getIntegerValue("city"));
            cityPostCost.setBusinessCode(weixinRequestBean.getBusinessCode());
            cityPostCost = otcCityPostCosSerMapper.byWhereQueryPo(cityPostCost);
            if(cityPostCost != null){
                postCost = postCost.add(cityPostCost.getCost());
            }

            OtcPostCompanyCostPo postCompanyCost = new OtcPostCompanyCostPo();
            postCompanyCost.setCompanyCode(weixinRequestBean.getStringValue("postCompany"));
            postCompanyCost = otcPostCompanyCostSerMapper.byWhereQueryPo(postCompanyCost);
            if(postCompanyCost != null){
                postCost = postCost.add(postCompanyCost.getAddCost());
            }

            if(postCost.compareTo(new BigDecimal(0)) < 1){
                postCost = new BigDecimal(6.00);
            }
            weixinRequestBean.setParameter("postCost",postCost);
        }
        return SystemContains.SUCCESS;
    }
}
