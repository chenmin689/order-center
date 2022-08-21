package com.cm.order.center.server.logic.impl;

import com.alibaba.fastjson.JSONObject;
import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.RedisStaticKeys;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 会员购物车中商品活动有效期检查
 */
@Service("queryCheckActivityLogic")
@Slf4j
public class QueryCheckActivityLogic implements ILogic<WeixinRequestBean,String> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String exec(WeixinRequestBean weixinRequestBean) {
        //验证活动是否有效  销售类型：1，普通销售；2，活动销售；3，批发销售
        if(weixinRequestBean.getCheckKey("activityCode")){
            List<String> activityCodeList = weixinRequestBean.getListString("activityCode");
            Map<String,Integer> activityMap = new HashMap<>();
            for(String activityCode : activityCodeList){
                String activityInfo = stringRedisTemplate.opsForValue().get(String.format(RedisStaticKeys.ACTIVITY,activityCode));
                if(StringUtils.isBlank(activityInfo)){
                    activityMap.put(activityCode,0);
                    continue;
                }
                JSONObject jsonObject = JSONObject.parseObject(activityInfo);
                Date endTime = jsonObject.getDate("endTime");
                if(endTime.getTime() - System.currentTimeMillis() < 0){
                    activityMap.put(activityCode,0);
                    continue;
                }
                activityMap.put(activityCode,1);
            }
            if(activityMap.size() > 0) {
                weixinRequestBean.getParameter().put("activityCode", activityMap);
            }
            weixinRequestBean.getParameter().remove("activityCode");
        }
        return SystemContains.SUCCESS;
    }
}
