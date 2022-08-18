/**
* @Title: OtcOrderDetailSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 订单明细表--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:10:09 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcOrderDetailVo;
import com.cm.order.center.dao.po.OtcOrderDetailPo;
/**
* @ClassName: OtcOrderDetailSerMapper
* @Description: 订单明细表--查询接口类
* @author chenmin
* @date Thu Aug 18 09:10:09 CST 2022
 */
public interface OtcOrderDetailSerMapper extends PersistenceSerMapper<OtcOrderDetailPo,OtcOrderDetailVo,Integer>{

}
