/**
* @Title: OtcOrderSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 会员订单管理--增删改接口类
* @author chenmin
* @date Thu Aug 18 10:31:54 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcOrderVo;
import com.cm.order.center.dao.po.OtcOrderPo;
/**
* @ClassName: OtcOrderSerMapper
* @Description: 会员订单管理--查询接口类
* @author chenmin
* @date Thu Aug 18 10:31:54 CST 2022
 */
public interface OtcOrderSerMapper extends PersistenceSerMapper<OtcOrderPo,OtcOrderVo,Integer>{

}
