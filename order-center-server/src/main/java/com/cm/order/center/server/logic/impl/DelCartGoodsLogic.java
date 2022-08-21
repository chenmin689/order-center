package com.cm.order.center.server.logic.impl;

import com.cm.architecture.commons.logic.ILogic;
import com.cm.architecture.commons.utils.SystemContains;
import com.cm.architecture.commons.weixin.WeixinRequestBean;
import com.cm.order.center.dao.mapper.edit.OtcUserCartEditMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("delCartGoodsLogic")
@Slf4j
public class DelCartGoodsLogic  implements ILogic<WeixinRequestBean,Integer> {

    @Resource
    private OtcUserCartEditMapper otcUserCartEditMapper;

    @Override
    public Integer exec(WeixinRequestBean weixinRequestBean) {
        Integer userId = weixinRequestBean.getTokenBean().getUserId();
        String cartSeq = weixinRequestBean.getStringValue("cartSeqs");
        if(StringUtils.isBlank(cartSeq)){
            return 0;
        }
        String[] seqS = cartSeq.split(",");
        List<Long> seqList = new ArrayList<>(seqS.length);
        for(String temp : seqS){
            if(StringUtils.isNotBlank(temp.trim())) {
                seqList.add(Long.valueOf(temp.trim()));
            }
        }
        int count = otcUserCartEditMapper.delGoods(userId,seqList);
        return count;
    }

}
