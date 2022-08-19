package com.cm.order.center.server.logic.impl;

import com.alibaba.fastjson.JSONObject;
import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.RedisStaticKeys;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.edit.OtcUserCartEditMapper;
import com.cm.order.center.dao.mapper.ser.OtcUserCartSerMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 活动有效期检查
 */
@Service("checkActivityLogic")
@Slf4j
public class CheckActivityLogic implements ILogic<WeixinRequestBean,String> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        int buyType = weixinRequestBean.getIntegerValue("buyType");
        //验证活动是否有效  销售类型：1，普通销售；2，活动销售；3，批发销售
        if(buyType == 2){
            if(weixinRequestBean.isNotNull("activityCode")){
                String activityCode = weixinRequestBean.getStringValue("activityCode");
                String activityInfo = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.ACTIVITY,activityCode));
                if(StringUtils.isBlank(activityInfo)){
                    return "商品加车失败，活动信息不存在";
                }
                JSONObject jsonObject = JSONObject.parseObject(activityInfo);
                Date startTime = jsonObject.getDate("startTime");
                Date endTime = jsonObject.getDate("endTime");
                if(System.currentTimeMillis() - startTime.getTime() < 0){
                    return "商品加车失败，活动还没有开始";
                }
                if(endTime.getTime() - System.currentTimeMillis() < 0){
                    return "商品加车失败，活动已经结束";
                }
                weixinRequestBean.getParameter().put("activityPrice",jsonObject.getBigDecimal("activityPrice"));
            }else{
                return "商品加车失败，活动编码不能为空";
            }
        }
        return SystemContains.SUCCESS;
    }
}
