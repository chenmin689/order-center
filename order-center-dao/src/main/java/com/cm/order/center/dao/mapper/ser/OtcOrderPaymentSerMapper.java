/**
* @Title: OtcOrderPaymentSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 订单支付表--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:09:05 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcOrderPaymentVo;
import com.cm.order.center.dao.po.OtcOrderPaymentPo;
/**
* @ClassName: OtcOrderPaymentSerMapper
* @Description: 订单支付表--查询接口类
* @author chenmin
* @date Thu Aug 18 09:09:05 CST 2022
 */
public interface OtcOrderPaymentSerMapper extends PersistenceSerMapper<OtcOrderPaymentPo,OtcOrderPaymentVo,Integer>{

}
