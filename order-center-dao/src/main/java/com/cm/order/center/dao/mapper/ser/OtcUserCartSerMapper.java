/**
* @Title: OtcUserCartSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 会员购物车表--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:10:59 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcUserCartVo;
import com.cm.order.center.dao.po.OtcUserCartPo;
/**
* @ClassName: OtcUserCartSerMapper
* @Description: 会员购物车表--查询接口类
* @author chenmin
* @date Thu Aug 18 09:10:59 CST 2022
 */
public interface OtcUserCartSerMapper extends PersistenceSerMapper<OtcUserCartPo,OtcUserCartVo,Integer>{

}
