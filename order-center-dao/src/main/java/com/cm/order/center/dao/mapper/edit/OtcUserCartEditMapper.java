/**
* @Title: OtcUserCartEditMapper
* @Package com.cm.order.center.dao.mapper.edit
* @Description: 会员购物车表--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:10:59 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.edit;

import com.cm.architecture.jdbc.mapper.PersistenceEditMapper;
import com.cm.order.center.dao.po.OtcUserCartPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: OtcUserCartEditMapper
* @Description: 会员购物车表--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:10:59 CST 2022
 */
public interface OtcUserCartEditMapper extends PersistenceEditMapper<OtcUserCartPo>{

    public int delGoods(@Param("userId") Integer userId,@Param("seqList") List<Long> seqList);
}
