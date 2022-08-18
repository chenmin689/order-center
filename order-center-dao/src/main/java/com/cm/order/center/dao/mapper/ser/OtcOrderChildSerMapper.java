/**
* @Title: OtcOrderChildSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 订单出库管理--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:15:46 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcOrderChildVo;
import com.cm.order.center.dao.po.OtcOrderChildPo;
/**
* @ClassName: OtcOrderChildSerMapper
* @Description: 订单出库管理--查询接口类
* @author chenmin
* @date Thu Aug 18 09:15:46 CST 2022
 */
public interface OtcOrderChildSerMapper extends PersistenceSerMapper<OtcOrderChildPo,OtcOrderChildVo,Integer>{

}
