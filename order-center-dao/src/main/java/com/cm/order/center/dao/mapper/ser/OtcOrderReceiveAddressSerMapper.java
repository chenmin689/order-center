/**
* @Title: OtcOrderReceiveAddressSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 订单收货地址表--增删改接口类
* @author chenmin
* @date Sun Sep 04 16:56:52 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcOrderReceiveAddressVo;
import com.cm.order.center.dao.po.OtcOrderReceiveAddressPo;
import java.util.Date;
/**
* @ClassName: OtcOrderReceiveAddressSerMapper
* @Description: 订单收货地址表--查询接口类
* @author chenmin
* @date Sun Sep 04 16:56:52 CST 2022
 */
public interface OtcOrderReceiveAddressSerMapper extends PersistenceSerMapper<OtcOrderReceiveAddressPo,OtcOrderReceiveAddressVo,Integer>{

}
