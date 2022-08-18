/**
* @Title: OtcOrderContractSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 订单履约表--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:18:47 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcOrderContractVo;
import com.cm.order.center.dao.po.OtcOrderContractPo;
/**
* @ClassName: OtcOrderContractSerMapper
* @Description: 订单履约表--查询接口类
* @author chenmin
* @date Thu Aug 18 09:18:47 CST 2022
 */
public interface OtcOrderContractSerMapper extends PersistenceSerMapper<OtcOrderContractPo,OtcOrderContractVo,Integer>{

}
