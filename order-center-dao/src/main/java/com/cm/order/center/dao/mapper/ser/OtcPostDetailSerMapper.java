/**
* @Title: OtcPostDetailSerMapper
* @Package com.cm.order.center.dao.mapper.ser
* @Description: 物流运转明细表--增删改接口类
* @author chenmin
* @date Thu Aug 18 09:20:39 CST 2022
* @version V1.0
*/
package com.cm.order.center.dao.mapper.ser;

import com.cm.architecture.jdbc.mapper.PersistenceSerMapper;
import com.cm.architecture.jdbc.entity.EditValueAndWhereEntity;
import com.cm.order.center.dao.vo.OtcPostDetailVo;
import com.cm.order.center.dao.po.OtcPostDetailPo;
/**
* @ClassName: OtcPostDetailSerMapper
* @Description: 物流运转明细表--查询接口类
* @author chenmin
* @date Thu Aug 18 09:20:39 CST 2022
 */
public interface OtcPostDetailSerMapper extends PersistenceSerMapper<OtcPostDetailPo,OtcPostDetailVo,String>{

}
